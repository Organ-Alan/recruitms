package com.hgl.recruitms.common.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**  
 * ClassName: JsonUtil <br/>  
 * date: 2017年12月6日 下午4:21:20 <br/>  
 * Description：Json转化工具类
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public class JsonUtil {
	public static ObjectMapper objectMapper;
	
	static{
		try {
			objectMapper = (ObjectMapper)Class.forName("com.fasterxml.jackson.databind.ObjectMapper").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public static void print(Object object){
        try {
            String str = objectMapper.writeValueAsString(object);
            System.out.println(str);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void printBeautiful(Object object) {
    	try {
            String str = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println(str);
        }catch (Exception e){
            e.printStackTrace();
        }
	}

    public static String serialize(Object object){
        try {
            String str = objectMapper.writeValueAsString(object);
            return str;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("序列化异常");
        }
    }

    public static String serializeBeautiful(Object object){
        try {
            String str = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            return str;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("序列化异常");
        }
    }
    
    public static <T> T deSerialize(String json,Class<T> clazz){
        try {
            return objectMapper.readValue(json,clazz);
        } catch (IOException e) {
            throw new IllegalStateException("反序列化出错",e);
        }
    }
    
    public static <T> T deSerialize(InputStream inputStream,Class<T> clazz){
        try {
            return objectMapper.readValue(inputStream,clazz);
        } catch (IOException e) {
            throw new IllegalStateException("反序列化出错",e);
        }
    }
    
    
    public static <T> List<T> deSerializeToList(String json,Class<T> tClass){
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class,tClass));
        } catch (IOException e) {
            throw new IllegalStateException("反序列化出错",e);
        }
    }
    
    public static <T> List<T> deSerializeToList(InputStream inputStream,Class<T> tClass){
        try {
            return objectMapper.readValue(inputStream, objectMapper.getTypeFactory().constructCollectionType(List.class,tClass));
        } catch (IOException e) {
            throw new IllegalStateException("反序列化出错",e);
        }
    }
}
