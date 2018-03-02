package com.hgl.recruitms.service;

import com.hgl.recruitms.model.Account;

/**  
 * ClassName: AccountService <br/>   
 * Description：登录校验接口
 * @author huanggl  
 * @version   
 * Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.  
 */
public interface AccountService {
	
    /**  
     * checkLogin:登录校验. <br/>  
     * @author huanggl
     * @param sUsername
     * @param sPassword
     * @return  
     */
    Account checkLogin(String sUsername,String sPassword);
}
