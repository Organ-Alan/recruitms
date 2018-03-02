package com.hgl.recruitms.common;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;


/**
 *  这个类的源代码从 MapperScannerConfigurer 拷贝下来，并加以改造，支持 classNameRegexPattern 属性，通过此属性，可以过滤符合此正则表达式的类名才由mybatis代理
 *  如下所示，要求类名要满足（注意classNameRegexPattern属性）mapper或dao结尾的（忽略大小写）。
 *  <code>
 *  <bean class="com.hgl.recruitms.scan.MyMapperConfiguration">
		<property name="basePackage" value="com.test.hgl"></property>
		<property name="classNameRegexPattern" value="(?i).*(mapper|dao)"></property>
		<property name="sqlSessionFactoryBeanName" value="sqlSessionFactorys"></property>
	</bean>
 *  </code>
 */
public class MapperScannerConfigurerEx implements BeanDefinitionRegistryPostProcessor, InitializingBean, ApplicationContextAware, BeanNameAware{
	private String basePackage;
	  private boolean addToConfig;
	  private SqlSessionFactory sqlSessionFactory;
	  private SqlSessionTemplate sqlSessionTemplate;
	  private String sqlSessionFactoryBeanName;
	  private String sqlSessionTemplateBeanName;
	  private Class<? extends Annotation> annotationClass;
	  private Class<?> markerInterface;
	  private ApplicationContext applicationContext;
	  private String beanName;
	  private boolean processPropertyPlaceHolders;
	  private BeanNameGenerator nameGenerator;
	  
	  private String classNameRegexPattern;

	  public MapperScannerConfigurerEx()
	  {
	    this.addToConfig = true;
	  }

	  public void setBasePackage(String basePackage)
	  {
	    this.basePackage = basePackage;
	  }

	  public void setAddToConfig(boolean addToConfig)
	  {
	    this.addToConfig = addToConfig;
	  }

	  public void setAnnotationClass(Class<? extends Annotation> annotationClass)
	  {
	    this.annotationClass = annotationClass;
	  }

	  public void setMarkerInterface(Class<?> superClass)
	  {
	    this.markerInterface = superClass;
	  }
	  
	  public void setClassNameRegexPattern(String classNameRegexPattern) {
		this.classNameRegexPattern = classNameRegexPattern;
	  }

	  @Deprecated
	  public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate)
	  {
	    this.sqlSessionTemplate = sqlSessionTemplate;
	  }

	  public void setSqlSessionTemplateBeanName(String sqlSessionTemplateName)
	  {
	    this.sqlSessionTemplateBeanName = sqlSessionTemplateName;
	  }

	  @Deprecated
	  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	  {
	    this.sqlSessionFactory = sqlSessionFactory;
	  }

	  public void setSqlSessionFactoryBeanName(String sqlSessionFactoryName)
	  {
	    this.sqlSessionFactoryBeanName = sqlSessionFactoryName;
	  }

	  public void setProcessPropertyPlaceHolders(boolean processPropertyPlaceHolders)
	  {
	    this.processPropertyPlaceHolders = processPropertyPlaceHolders;
	  }

	  public void setApplicationContext(ApplicationContext applicationContext)
	  {
	    this.applicationContext = applicationContext;
	  }

	  public void setBeanName(String name)
	  {
	    this.beanName = name;
	  }

	  public BeanNameGenerator getNameGenerator()
	  {
	    return this.nameGenerator;
	  }

	  public void setNameGenerator(BeanNameGenerator nameGenerator)
	  {
	    this.nameGenerator = nameGenerator;
	  }

	  public void afterPropertiesSet()
	    throws Exception
	  {
	    Assert.notNull(this.basePackage, "Property 'basePackage' is required");
	  }

	  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
	  {
	  }

	  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
	    throws BeansException
	  {
	    if (this.processPropertyPlaceHolders) {
	      processPropertyPlaceHolders();
	    }

	    ClassPathMapperScanner scanner = new ClassPathMapperScanner(registry);
	    scanner.setAddToConfig(this.addToConfig);
	    scanner.setAnnotationClass(this.annotationClass);
	    scanner.setMarkerInterface(this.markerInterface);
	    scanner.setSqlSessionFactory(this.sqlSessionFactory);
	    scanner.setSqlSessionTemplate(this.sqlSessionTemplate);
	    scanner.setSqlSessionFactoryBeanName(this.sqlSessionFactoryBeanName);
	    scanner.setSqlSessionTemplateBeanName(this.sqlSessionTemplateBeanName);
	    scanner.setResourceLoader(this.applicationContext);
	    scanner.setBeanNameGenerator(this.nameGenerator);
	    
	    //-------- 这是改造的部分 原来是 scanner.registerFilters 被改成下面这行代码 -----------
	    registerFilters(scanner);
	    
	    scanner.scan(StringUtils.tokenizeToStringArray(this.basePackage, ",; \t\n"));
	  }
	  
	  public void registerFilters(ClassPathMapperScanner scanner)
	  {
	    boolean acceptAllInterfaces = true;

	    if (this.annotationClass != null) {
	    	scanner.addIncludeFilter(new AnnotationTypeFilter(this.annotationClass));
	      acceptAllInterfaces = false;
	    }

	    if (this.markerInterface != null) {
	    	scanner.addIncludeFilter(new AssignableTypeFilter(this.markerInterface)
	      {
	        protected boolean matchClassName(String className) {
	          return false;
	        }
	      });
	      acceptAllInterfaces = false;
	    }
	    
	    //--------------------------------
	    /** 这是改造（增加）的部分 */
	    if (this.classNameRegexPattern != null) {
	    	Pattern pattern = Pattern.compile(classNameRegexPattern);
	    	scanner.addIncludeFilter(new RegexPatternTypeFilter(pattern));
	    	acceptAllInterfaces = false;
	    }
	    //--------------------------------

	    if (acceptAllInterfaces)
	    {
	    	scanner.addIncludeFilter(new TypeFilter() {
	        public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
	          return true;
	        }

	      });
	    }

	    scanner.addExcludeFilter(new TypeFilter() {
	      public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
	        String className = metadataReader.getClassMetadata().getClassName();
	        return className.endsWith("package-info");
	      }
	    });
	  }

	  private void processPropertyPlaceHolders()
	  {
	    Map<String,PropertyResourceConfigurer> prcs = this.applicationContext.getBeansOfType(PropertyResourceConfigurer.class);

	    if ((!(prcs.isEmpty())) && (this.applicationContext instanceof GenericApplicationContext)) {
	      BeanDefinition mapperScannerBean = ((GenericApplicationContext)this.applicationContext).getBeanFactory().getBeanDefinition(this.beanName);

	      DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
	      factory.registerBeanDefinition(this.beanName, mapperScannerBean);

	      for (PropertyResourceConfigurer prc : prcs.values()) {
	        prc.postProcessBeanFactory(factory);
	      }

	      PropertyValues values = mapperScannerBean.getPropertyValues();

	      this.basePackage = updatePropertyValue("basePackage", values);
	      this.sqlSessionFactoryBeanName = updatePropertyValue("sqlSessionFactoryBeanName", values);
	      this.sqlSessionTemplateBeanName = updatePropertyValue("sqlSessionTemplateBeanName", values);
	    }
	  }

	  private String updatePropertyValue(String propertyName, PropertyValues values) {
	    PropertyValue property = values.getPropertyValue(propertyName);

	    if (property == null) {
	      return null;
	    }

	    Object value = property.getValue();

	    if (value == null) {
	      return null;
	    }
	    if (value instanceof String) {
	      return value.toString();
	    }
	    if (value instanceof TypedStringValue) {
	      return ((TypedStringValue)value).getValue();
	    }
	    return null;
	  }
}
