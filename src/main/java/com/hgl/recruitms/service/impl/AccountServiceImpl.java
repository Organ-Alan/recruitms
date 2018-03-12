package com.hgl.recruitms.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.dao.AccountMapper;
import com.hgl.recruitms.enums.DataStatusEnum;
import com.hgl.recruitms.model.Account;
import com.hgl.recruitms.model.AccountExample;
import com.hgl.recruitms.model.AccountExample.Criteria;
import com.hgl.recruitms.service.AccountInfoService;

@Service
public class AccountServiceImpl implements AccountInfoService {
	static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountMapper accountMapper;

	@Override
	public PageInfo<Account> listAccountyPage(Integer pageIndex, Integer pageSize, String sUsername, String sUserType) {
		// 拼装条件
		AccountExample example = new AccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andNAcnNoIsNotNull();
		// 过滤数据状态为删除状态的账户
		criteria.andSExtValue1EqualTo(DataStatusEnum.VALID.getCode());
		logger.debug("获取账户信息列表：账户名称" + sUsername + "   账户类型：" + sUserType);
		// 模糊查询
		if (StringUtils.hasText(sUsername)) {
			criteria.andSUsernameLike("%" + sUsername + "%");
		}
		if (StringUtils.hasText(sUserType)) {
			criteria.andSUserTypeLike("%" + sUserType + "%");
		}
		example.setOrderByClause(" D_RG_TIME ASC ");
		logger.debug("账户信息列表当前显示第" + pageIndex + "页且当前页面展示的条数" + pageSize);
		// 调用静态方法，设置分页参数即可，随后的第一次查询的sql语句会自动被分页插件改装成带有分页查询的sql语句
		PageHelper.startPage(pageIndex, pageSize);
		// 获取满足条件的产品改造进度表的数据。
		List<Account> dictList = accountMapper.selectByExample(example);
		return new PageInfo<Account>(dictList);
	}

	@Override
	public Account getAccount(Integer nAcnNo) {
		Account account = new Account();
		AccountExample accountExample = new AccountExample();
		// 拼装条件（编码）
		accountExample.createCriteria().andNAcnNoEqualTo(nAcnNo);
		List<Account> accountList = accountMapper.selectByExample(accountExample);
		if (accountList != null && accountList.size() > 0) {
			account = accountList.get(0);// 获取账户信息信息
		}
		return account;
	}

	@Override
	public boolean insertAccount(Account account) {
		account.setdRgTime(new Date());
		account.setsPassword("111111");
		int count = accountMapper.insertSelective(account);
		logger.info("新增账户信息:" + account.toString() + "，结果：" + (count > 0));
		return count > 0;
	}

	@Override
	public boolean updateAccountInfo(Account account) {
		// 通过主键账户信息编码进行修改
		int count = accountMapper.updateByPrimaryKeySelective(account);
		logger.debug("调用数据库修改账户信息信息的条数为::" + count);
		// 当修改账户信息信息失败时
		if (count != 1) {
			logger.error("修改基础信息失败,修改基础信息数据为：" + account.toString() + "，条件为:" + account.getnAcnNo());
			throw new RuntimeException("修改基础信息失败，抛出异常，事务回滚");
		}
		return count > 0;
	}

	@Override
	public boolean delAccount(Integer nAcnNo) {
		AccountExample updateExample = new AccountExample();
		AccountExample.Criteria updateCriteria = updateExample.createCriteria();
		updateCriteria.andNAcnNoEqualTo(nAcnNo);
		Account account = new Account();
		account.setsExtValue1(DataStatusEnum.INVALID.getCode());
		int count = accountMapper.updateByExampleSelective(account, updateExample);
		if (1 != count) {
			// 当删除数量，与受影响行数不符时，抛出异常，事务回滚
			logger.info("删除失败" + nAcnNo);
			throw new IndexOutOfBoundsException("删除失败");
		}
		logger.debug("删除：" + nAcnNo + "考生信息，结果：" + (count > 0));
		return count > 0;
	}
}
