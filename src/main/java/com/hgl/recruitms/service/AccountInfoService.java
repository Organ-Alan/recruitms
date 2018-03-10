package com.hgl.recruitms.service;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.model.Account;

/**
 * ClassName: AccountService <br/>
 * Description：账号管理接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
public interface AccountInfoService {

	
	/**  
	 * listAccountyPage:. <br/>  
	 * @author huanggl
	 * @param pageIndex
	 * @param pageSize
	 * @param sUsername
	 * @param sUserType
	 * @return  
	 */
	PageInfo<Account> listAccountyPage(Integer pageIndex, Integer pageSize,
			String sUsername,String sUserType);
	
	/**  
	 * getAccount:. <br/>  
	 * @author huanggl
	 * @param nAcnNo
	 * @return  
	 */
	Account getAccount(Integer nAcnNo);
	
	boolean insertAccount(Account account);
	
	boolean updateAccountInfo(Account account);
	
	
	boolean delAccount(Integer nAcnNo);
}
