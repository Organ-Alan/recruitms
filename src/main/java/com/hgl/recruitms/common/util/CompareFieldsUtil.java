package com.hgl.recruitms.common.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**  
 * ClassName: CompareFields <br/>  
 * date: 2017年12月26日 下午2:05:24 <br/>  
 * Description： 比较两个实体的有哪些属性值不同
 * @author huanggl 
 * @version   
 * Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved. 
 */
public class CompareFieldsUtil {   
	static Logger logger = LoggerFactory.getLogger(CompareFieldsUtil.class);
	
    /** 
     * 比较两个实体属性值，返回一个map以有差异的属性名为key，value为一个map存要修改对象和业务类型 
     * @param oldObj 进行属性比较的旧对象
     * @param newObj 进行属性比较的新对象 
     * @param ignoreList 选择忽略比较的属性集合 
     * @return 属性差异比较结果map 
     */   
    public static Map<String, Map<String, Object>> compareFields(Object oldObj, Object newObj, List<String> ignoreList) {  
        try{  
            Map<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>();  
 
            if (oldObj.getClass() != newObj.getClass()) {
            	logger.error("进行比较的两个对象类型必须相同！");
            	throw new IllegalArgumentException("进行比较的两个对象类型必须相同！");
            }
            
            Class<? extends Object> clazz = oldObj.getClass();  
            // 获取object的属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {  // 遍历所有属性 
                String name = field.getName();  // 属性名 
                
                if(ignoreList != null && ignoreList.contains(name)){// 如果当前属性选择忽略比较，跳到下一次循环  
                    continue;  
                }  
                
                field.setAccessible(true);
                Object oldValue = field.get(oldObj);  //旧对象值
                Object newValue = field.get(newObj);  //新对象值
                
                //旧值为空，且新值不为空的情况 或者 旧值不为空，且旧值不等于新值的情况，则表示两个值不一致，添加信息（属性名，变化前后的值）进map里
                boolean differented = (oldValue == null && newValue != null && newValue != "") || (oldValue != null && !oldValue.equals(newValue));
                if(differented){  
                    Map<String, Object> mapItem = new HashMap<String, Object>();  
                    mapItem.put("oldValue", oldValue);  
                    mapItem.put("newValue", newValue);  
                    map.put(name, mapItem); 
                } 
            }  
            return map;  
        }catch(Exception e){  
            logger.error("比较两个对象不同属性值出错！", e);
            throw new RuntimeException("比较两个对象不同属性值出错！", e);  
        }  
    }  
    
    /**  
     * getFieldValue:(通过属性名获取对象的属性值). <br/>  
     * @author huanggl
     * @param obj
     * 			要获取属性的对象
     * @param attributeName
     * 			属性名
     * @param clazz
     * 			返回类型
     * @return  
     */
    @SuppressWarnings("unchecked")
	public static <E> E getFieldValue(Object obj, String attributeName, Class<E> clazz){
		if(attributeName == null){
			return null;
		}
		
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {// 遍历所有属性
        	if(field.getName().equals(attributeName)){
	            try {
	            	field.setAccessible(true);
	                Object value = field.get(obj);
	                if(value != null && value.getClass() == clazz){
	                	return (E)value;
	                }
	            } catch (Exception e) {
	            	logger.error("获取属性 " + attributeName + " 失败！", e);
	            	throw new RuntimeException("获取属性 " + attributeName + " 失败！", e);
	            }
        	}
        }
		return null;
	}
    
    //类型都转换为String，目前只考虑String，Character，Integer，Long，BigDecimal，Float，Double，Short， Date几种类型
    /**  
     * ObjectToString:(Object对象转换为String字符串). <br/>  
     * @author huanggl
     * @param obj
     * @return  
     */
    public static String objectToString(Object obj) {
	    try {
	    	if(obj == null){
	    		return "";
	    	}
	    	
	    	if(obj instanceof String || obj instanceof Character || obj instanceof Integer
					|| obj instanceof Long || obj instanceof BigDecimal || obj instanceof Float 
					|| obj instanceof Double || obj instanceof Short){
				return String.valueOf(obj);
			}else if(obj instanceof Date){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
				return sdf.format((Date)obj);  
			}else {
				logger.error("不支持的数据转换类型！");
				throw new ClassCastException("不支持的数据转换类型！");
			}
	    } catch(Exception e) {
			logger.error("属性类型转换出错！", e);
			throw new ClassCastException("属性类型转换出错！");
		}
	}
    
    /**  
     * setField:(根据属性名和属性值为对象赋值). <br/>  
     * @author huanggl
     * @param obj
     * 			要赋值的对象
     * @param attributeName
     * 			属性名
     * @param attributeValue  
     * 			属性值
     */
    public static void setField(Object obj, String attributeName, Object attributeValue) {
    	try {	
    		Field field = null;
			try {
				field = obj.getClass().getDeclaredField(attributeName);  //获取该属性
				field.setAccessible(true);  //设置权限
			} catch (NoSuchFieldException e) {
				logger.error("从{}获取属性{}失败：", obj.getClass(), attributeName);
				throw new RuntimeException("从"+obj.getClass()+"获取属性"+attributeName+"失败：", e);
			}  
    		
    		Class<?> type = field.getType();
    		field.setAccessible(true);
    		
    		if(attributeValue == null || attributeValue.toString() == ""){
    			field.set(obj, null);
    			return;
    		}
    		
    		//目前只考虑String，Character，Integer，Long，BigDecimal， Float，Double，Short，Date几种类型
    		if(type == Integer.class){
    			field.set(obj, Integer.valueOf(attributeValue.toString()));
    		}else if(type == Character.class){
    			field.set(obj, Character.valueOf(attributeValue.toString().charAt(0)));
    		}
    		else if(type == String.class){
    			field.set(obj, attributeValue.toString());
    		}
    		else if(type == Long.class){
    			field.set(obj, Long.valueOf(attributeValue.toString()));
    		}
    		else if(type == BigDecimal.class){
    			field.set(obj, new BigDecimal(attributeValue.toString()));
    		}
    		else if(type == Float.class){
    			field.set(obj, Float.valueOf(attributeValue.toString()));
    		}
    		else if(type == Double.class){
    			field.set(obj, Double.valueOf(attributeValue.toString()));
    		}
    		else if(type == Short.class){
    			field.set(obj, Short.valueOf(attributeValue.toString()));
    		}
    		else if(type == Date.class){
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
				Date dAfterModify = sdf.parse(attributeValue.toString());
				field.set(obj, dAfterModify);
    		}else {
				logger.error("不支持的数据转换类型！");
				throw new ClassCastException("不支持的数据转换类型！");
			}
    	}catch(Exception e) {
	    	logger.error("数据类型转换出错！", e);
	    	throw new RuntimeException("数据类型转换出错！", e);
	    }
    }

      
}  
