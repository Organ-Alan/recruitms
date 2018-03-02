package com.hgl.recruitms.common.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hgl.recruitms.common.sys.controller.response.CommonResponseObject;
import com.hgl.recruitms.common.web.annotation.Anonymous;
import com.hgl.recruitms.common.web.restful.response.PredefinedErrorEnum;
import com.hgl.recruitms.common.web.restful.response.ResponseObject;
import com.hgl.recruitms.common.web.util.JsonUtil;

/**  
 * ClassName: AuthInterceptor <br/>  
 * date: 2017年12月6日 下午4:14:26 <br/>  
 * Description：单点登录拦截器
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LogManager.getLogger(AuthInterceptor.class);
	
	private final static String TOKEN_KEY = "token";
	public final static String REQUEST_ATTR_TOKEN_KEY = "PMS_TOKEN";
	
	/*@Value("${token.key}")
    private String key;*/
	@Autowired
	private CommonResponseObject builder;
	

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object obj) throws Exception {

    	if(request.getMethod().equalsIgnoreCase("options")){
    		logger.debug("options请求，直接放开");
    		return true;
    	}
    	
        if(obj instanceof HandlerMethod){
            if(((HandlerMethod)obj).getBeanType().isAnnotationPresent(Anonymous.class)){
                return true;
            }else if(((HandlerMethod)obj).getMethod().isAnnotationPresent(Anonymous.class)){
                return true;
            }
        }
        
        boolean validUser = false;   
        //单点登录，从request中获取用户名称
    	String sUsername = request.getRemoteUser();
    	if(StringUtils.hasText(sUsername)){
    		validUser = true;
    		request.setAttribute(REQUEST_ATTR_TOKEN_KEY, sUsername);
    	}else{
    		//TODO 在跟CAS对接之前，从token中获取用户名
    		String token = request.getParameter(TOKEN_KEY);
            if(!StringUtils.hasText(token)){
            	token = request.getHeader(TOKEN_KEY);
            }
            if(StringUtils.hasText(token)){
                request.setAttribute(REQUEST_ATTR_TOKEN_KEY, token);
            	validUser = true;
            }
    	}

        if(!validUser){//无有效用户信息
			ResponseObject<Object> responseObject = builder.error(PredefinedErrorEnum.UNAUTHORIZED.getErrorCode());
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().print(JsonUtil.serialize(responseObject));
            return false;
        } 

        return true;
    }
}
