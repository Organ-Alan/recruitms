package com.hgl.recruitms.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgl.recruitms.dao.AccountMapper;
import com.hgl.recruitms.model.Account;
import com.hgl.recruitms.model.AccountExample;
import com.hgl.recruitms.service.AccountService;


/**  
 * ClassName: DictionaryServiceImpl <br/>  
 * date: 2017年11月14日 上午11:04:13 <br/>  
 * Description：根据字典编码查询字典值
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
@Service
public class AccountServiceImpl implements AccountService {
	static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountMapper accountMapper;

	/**  
	 * 校验账户登录.  
	 * @see com.hgl.recruitms.service.AccountService#checkLogin(java.lang.String, java.lang.String)  
	 */
	@Override
	public Account checkLogin(String sUsername, String sPassword) {
		Account account = null;
		AccountExample example = new AccountExample();
		example.createCriteria().andSUsernameEqualTo(sUsername);
		List<Account> accounts = accountMapper.selectByExample(example);
		//校验返回结果是否为空，不为空则返回结果集的第一条记录
		if (CollectionUtils.isNotEmpty(accounts)) {
			account = accounts.get(0);
		}
		return account;
	}
}
