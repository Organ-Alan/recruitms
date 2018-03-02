package com.hgl.recruitms.common.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**  
 * ClassName: TimeAnalysis <br/>  
 * date: 2017年12月6日 下午4:15:17 <br/>  
 * Description：时间线程分析器
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public class TimeAnalysis extends HandlerInterceptorAdapter {
	private static final Logger logger = LogManager.getLogger(TimeAnalysis.class);
    private long criticalValue = 500;

    private NamedThreadLocal<Long> timeAnalysisThreadLocal =
            new NamedThreadLocal<Long>("timeAnalysisThreadLocal");
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        long beginTime = System.currentTimeMillis();//1、开始时间
        timeAnalysisThreadLocal.set(beginTime);//线程绑定变量（该数据只有当前请求的线程可见）
        return true;//继续流程
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();//2、结束时间
        long beginTime = timeAnalysisThreadLocal.get();//得到线程绑定的局部变量（开始时间）
        long consumeTime = endTime - beginTime;//3、消耗的时间
        if(consumeTime > criticalValue) {//此处认为处理时间超过n毫秒的请求为慢请求
            logger.warn(String.format("耗时较长：%s %s 用时 %d 毫秒", request.getMethod(), request.getRequestURI(), consumeTime));
        }
    }
}
