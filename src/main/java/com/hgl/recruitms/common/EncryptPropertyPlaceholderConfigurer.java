package com.hgl.recruitms.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

/**  
 * ClassName: EncryptPropertyPlaceholderConfigurer <br/>  
 * date: 2017年12月6日 下午4:06:29 <br/>  
 * Description：配置数据库密码加密
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public class EncryptPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {

	private static final String ENCRYPTED_KEY = "password";
	private static final String ENCRYPTED_PREFIX = "Encrypted:{";
	private static final String ENCRYPTED_SUFFIX = "}";
	
	private static Pattern encryptedPattern = Pattern.compile("\\s*?"+Pattern.quote(ENCRYPTED_PREFIX)+"(.+)"+Pattern.quote(ENCRYPTED_SUFFIX)+"\\s*"); // 加密属性特征正则

	private static Logger logger = LogManager.getLogger(EncryptPropertyPlaceholderConfigurer.class);

	protected Resource[] locations;
	private Set<String> encryptedProps = Collections.emptySet();

	/*
	 * set the locations of properties files.
	 * @see org.springframework.core.io.support.PropertiesLoaderSupport#setLocations(org.springframework.core.io.Resource[])
	 */
	@Override
	public void setLocations(Resource... locations) { // 由于location是父类私有，所以需要记录到本类的locations中
		super.setLocations(locations);
		this.locations = locations;
	}

	/*
	 * set the location of properties file.
	 * @see org.springframework.core.io.support.PropertiesLoaderSupport#setLocation(org.springframework.core.io.Resource)
	 */
	@Override
	public void setLocation(Resource location) { // 由于location是父类私有，所以需要记录到本类的locations中
		super.setLocation(location);
		this.locations = new Resource[] { location };
	}
	
	public void setEncryptedProps(Set<String> encryptedProps) {
		this.encryptedProps = encryptedProps;
	}

	/*
	 *
	 * @see org.springframework.beans.factory.config.PropertyResourceConfigurer#convertProperty(String propertyName, String propertyValue)
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (encryptedProps.contains(propertyName)) { // 发现是否加密属性
			final Matcher matcher = encryptedPattern.matcher(propertyValue); // 判断该属性是否已经加密
			if (matcher.matches()) { // 已经加密，进行解密
				propertyValue = decrypt(propertyValue); // 进行解密

				if (propertyValue == null) { // !=null说明正常，其他说明解密失败
					logger.error("Decrypt " + propertyName + "=" + propertyValue + " error!");
				}
			}
		}
		return super.convertProperty(propertyName, propertyValue); // 将处理过的值传给父类继续处理
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.config.PropertyResourceConfigurer#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
	 */
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		super.postProcessBeanFactory(beanFactory); // 正常执行属性文件加载

		for (Resource location : locations) { // 加载完后，遍历location，对properties进行加密

			try {
				final File file = location.getFile();
				if (file.isFile()) { // 如果是一个普通文件

					if (file.canWrite()) { // 如果有写权限
						this.encryptFile(file); // 调用文件加密方法
					} else {
						if (logger.isWarnEnabled()) {
							logger.warn("File '" + location + "' can not be write!");
						}
					}

				} else {
					if (logger.isWarnEnabled()) {
						logger.warn("File '" + location + "' is not a normal file!");
					}
				}

			} catch (IOException e) {
				if (logger.isWarnEnabled()) {
					logger.warn("File '" + location + "' is not a normal file!");
				}
			}
		}

	}



	/**
	 * 属性文件加密方法
	 *
	 * @param file
	 */
	private void encryptFile(File file) {
		List<String> outputLine = new ArrayList<String>(); // 定义输出行缓存

		boolean doEncrypt = false; // 是否加密属性文件标识

		BufferedReader bufferedReader = null;
		try {

			bufferedReader = new BufferedReader(new FileReader(file));

			String line = null;

			do {

				line = bufferedReader.readLine(); // 按行读取属性文件
				if (line != null) { // 判断是否文件结束
					if (StringUtils.hasText(line)) { // 是否为空行
						line = line.trim(); // 取掉左右空格
						if (!line.startsWith("#")) {// 如果是非注释行
							int eIndex = line.indexOf("="); // 将属性名与值分离（修正1）
							String key = line.substring(0, eIndex).trim(); // 属性名
							String value = line.substring(eIndex + 1).trim(); // 属性值
							if (key != null && value != null) {
								if (encryptedProps.contains(key)) { // 发现是否加密属性
									final Matcher matcher = encryptedPattern.matcher(value);
									if (!matcher.matches()) { // 如果是非加密格式，则进行加密
										value = encrypt(value); // 进行加密
										line = key + " = " + value; // 生成新一行的加密串
										doEncrypt = true; // 设置加密属性文件标识
										if (logger.isDebugEnabled()) {
											logger.debug("encrypt property:" + key);
										}
									}
								}
							}
						}
					}
					outputLine.add(line);
				}

			} while (line != null);

		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}

		if (doEncrypt) { // 判断属性文件加密标识
			BufferedWriter bufferedWriter = null;
			File tmpFile = null;
			try {
				tmpFile = File.createTempFile(file.getName(), null,
						file.getParentFile()); // 创建临时文件

				if (logger.isDebugEnabled()) {
					logger.debug("Create tmp file '"
							+ tmpFile.getAbsolutePath() + "'.");
				}

				bufferedWriter = new BufferedWriter(new FileWriter(tmpFile));

				final java.util.Iterator<String> iterator = outputLine
						.iterator();
				while (iterator.hasNext()) { // 将加密后内容写入临时文件
					bufferedWriter.write(iterator.next());
					if (iterator.hasNext()) {
						bufferedWriter.newLine();
					}
				}

				bufferedWriter.flush();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			} finally {
				if (bufferedWriter != null) {
					try {
						bufferedWriter.close();
					} catch (IOException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}

			File backupFile = new File(file.getAbsoluteFile() + "_"
					+ System.currentTimeMillis()); // 准备备份文件名

			// 以下为备份，异常恢复机制
			if (!file.renameTo(backupFile)) { // 重命名原properties文件，（备份）
				logger.error("Could not encrypt the file '"
						+ file.getAbsoluteFile() + "'! Backup the file failed!");
				if(tmpFile != null){
					tmpFile.delete(); // 删除临时文件
				}				
			} else {
				if (logger.isDebugEnabled()) {
					logger.debug("Backup the file '"
							+ backupFile.getAbsolutePath() + "'.");
				}

				if (!tmpFile.renameTo(file)) { // 临时文件重命名失败 （加密文件替换原失败）
					logger.error("Could not encrypt the file '"
							+ file.getAbsoluteFile()
							+ "'! Rename the tmp file failed!");

					if (backupFile.renameTo(file)) { // 恢复备份
						if (logger.isInfoEnabled()) {
							logger.info("Restore the backup, success.");
						}
					} else {
						logger.error("Restore the backup, failed!");
					}
				} else { // （加密文件替换原成功）

					if (logger.isDebugEnabled()) {
						logger.debug("Rename the file '"
								+ tmpFile.getAbsolutePath() + "' -> '"
								+ file.getAbsoluteFile() + "'.");
					}

					boolean dBackup = backupFile.delete();// 删除备份文件

					if (logger.isDebugEnabled()) {
						logger.debug("Delete the backup '"
								+ backupFile.getAbsolutePath() + "'.("
								+ dBackup + ")");
					}
				}
			}

		}

	}

	/*
	 * encrypt the string
	 * @param String str
	 * @return String
	 */
	public static String encrypt(String str) {
		String result = Base64Utils.encodeToString(AesDecoder.encrypt(str, ENCRYPTED_KEY));
		result = ENCRYPTED_PREFIX + result + ENCRYPTED_SUFFIX;
		return result;
	}

	/*
	 * decrypt the string
	 * @param String str
	 * @return String
	 */
	public static String decrypt(String str) {
		String result = null;
		Matcher matcher = encryptedPattern.matcher(str); // 判断该属性是否已经加密

		if (matcher.find()) {
			result = matcher.group(1);
		} else {
			logger.error("the value of {} can't not be decrypted!", str);
			return null;
		}

		byte[] bytes = AesDecoder.decrypt(Base64Utils.decodeFromString(result), ENCRYPTED_KEY);

		return new String(bytes);
	}
}