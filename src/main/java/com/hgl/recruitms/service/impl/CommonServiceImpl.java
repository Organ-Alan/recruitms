package com.hgl.recruitms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.common.util.CompareFieldsUtil;
import com.hgl.recruitms.dao.AccountMapper;
import com.hgl.recruitms.dao.AuditInfoMapper;
import com.hgl.recruitms.enums.AuditStatusEnum;
import com.hgl.recruitms.model.Account;
import com.hgl.recruitms.model.AccountExample;
import com.hgl.recruitms.model.AuditInfo;
import com.hgl.recruitms.model.AuditInfoExample;
import com.hgl.recruitms.model.Dictionary;
import com.hgl.recruitms.service.CommonService;
import com.hgl.recruitms.service.DictionaryService;

@Service
public class CommonServiceImpl<T> implements CommonService<T> {
	static Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);
	@Autowired
	private AuditInfoMapper auditInfoMapper;

	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private DictionaryService dictionaryService;

	/**
	 * 校验账户登录.
	 * 
	 * @see com.hgl.recruitms.service.CommonService#checkLogin(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public boolean checkLogin(String sUsername, String sPassword) {
		AccountExample example = new AccountExample();
		example.createCriteria().andSUsernameEqualTo(sUsername);
		List<Account> accounts = accountMapper.selectByExample(example);
		// 校验返回结果是否为空
		if (!CollectionUtils.isEmpty(accounts)) {
			// 判断密码是否正确
			if (accounts.get(0).getsPassword().equals(sPassword)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 比较两个对象的属性值，获取不同属性对审核信息表进行批量插入，全部插入成功返回true，否则false，支持忽略某些属性.
	 * 
	 * @see com.efunds.pms.common.sys.service.AuditInfoService#checkDiffAndInsert(java.lang.Object,
	 *      java.lang.Object, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean checkDiffAndInsert(T oldObj, T newObj, List<String> ignore, String sCreatorNo, String sCreator) {
		// 比较两个对象的属性值，返回不一样的属性封装成map集合
		Map<String, Map<String, Object>> map = CompareFieldsUtil.compareFields(oldObj, newObj, ignore);

		boolean isAllSuccess = true; // 判断插入语句是否全部执行成功
		if (map != null && !map.isEmpty()) { // 两个对象有差别
			Set<Entry<String, Map<String, Object>>> entrys = map.entrySet();
			for (Map.Entry<String, Map<String, Object>> entry : entrys) {
				String attributeName = entry.getKey(); // 有差别的属性名
				AuditInfo auditInfo = new AuditInfo();

				Map<String, Object> entryMap = entry.getValue();
				Object oldValue = entryMap.get("oldValue"); // 原数据
				Object newValue = entryMap.get("newValue"); // 新数据
				logger.debug("数据修改————");
				logger.debug("对象:" + oldObj.getClass().getName() + ",属性名：" + attributeName + ",值：" + oldValue + "-->"
						+ newValue);

				// 设置属性
				auditInfo.setsModifyItemid(attributeName);
				// 将Object对象转换为String，并设值进对象里准备保存进数据库
				String sOldValue = CompareFieldsUtil.objectToString(oldValue);
				String sNewValue = CompareFieldsUtil.objectToString(newValue);
				auditInfo.setsBeforeModify(String.valueOf(sOldValue));
				auditInfo.setsAfterModify(String.valueOf(sNewValue));

				// 设置属性
				auditInfo.setdCreateTime(new Date()); // 创建时间
				auditInfo.setsCreatorNo(sCreatorNo); // 创建人ID
				auditInfo.setsCreator(sCreator); // 创建人
				auditInfo.setsStatus(AuditStatusEnum.AUDIT.getCode()); // 设置默认属性值——待审核
				auditInfo.setnDeptNo(CompareFieldsUtil.getFieldValue(oldObj, "nDeptNo", Integer.class));
				auditInfo.setsShortName(CompareFieldsUtil.getFieldValue(oldObj, "sShortName", String.class));
				auditInfo.setsFullName(CompareFieldsUtil.getFieldValue(oldObj, "sFullName", String.class));
				auditInfo.setsDeptCode(CompareFieldsUtil.getFieldValue(oldObj, "sDeptCode", String.class));

				// 循环插入数据
				int count = auditInfoMapper.insert(auditInfo);
				if (count < 1) {
					isAllSuccess = false;
					logger.error("审核信息表插入失败：" + auditInfo.toString());
					throw new RuntimeException("审核信息表插入失败!失败数据：" + auditInfo.toString());
				} else {
					logger.info("审核信息表插入成功：" + auditInfo.toString());
				}
			}
		}

		return isAllSuccess;
	}

	/**
	 * 针对公募院系专业的自动审核通过，比较两个对象的属性值，获取不同属性对审核信息表进行批量插入，全部插入成功返回true，否则false，支持忽略某些属性.
	 * 
	 * @see com.efunds.pms.common.sys.service.auditInfoService#checkDiffAndInsert(java.lang.Object,
	 *      java.lang.Object, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean PublicCheckDiffAndInsert(T oldObj, T newObj, List<String> ignore, String sCreatorNo,
			String sCreator) {
		// 比较两个对象的属性值，返回不一样的属性封装成map集合
		Map<String, Map<String, Object>> map = CompareFieldsUtil.compareFields(oldObj, newObj, ignore);

		boolean isAllSuccess = true; // 判断插入语句是否全部执行成功
		if (map != null && !map.isEmpty()) { // 两个对象有差别
			Set<Entry<String, Map<String, Object>>> entrys = map.entrySet();
			for (Map.Entry<String, Map<String, Object>> entry : entrys) {
				String attributeName = entry.getKey(); // 有差别的属性名
				AuditInfo auditInfo = new AuditInfo();

				Map<String, Object> entryMap = entry.getValue();
				Object oldValue = entryMap.get("oldValue"); // 原数据
				Object newValue = entryMap.get("newValue"); // 新数据
				logger.debug("数据修改————");
				logger.debug("对象:" + oldObj.getClass().getName() + ",属性名：" + attributeName + ",值：" + oldValue + "-->"
						+ newValue);

				// 设置属性
				auditInfo.setsModifyItemid(attributeName);
				// 将Object对象转换为String，并设值进对象里准备保存进数据库
				String sOldValue = CompareFieldsUtil.objectToString(oldValue);
				String sNewValue = CompareFieldsUtil.objectToString(newValue);
				auditInfo.setsBeforeModify(sOldValue);
				auditInfo.setsAfterModify(sNewValue);

				// 设置属性
				auditInfo.setdCreateTime(new Date()); // 创建时间
				auditInfo.setsCreatorNo(sCreatorNo); // 创建人ID
				auditInfo.setsCreator(sCreator); // 创建人
				auditInfo.setsStatus(AuditStatusEnum.AUDIT.getCode()); // 其它，设置默认属性值——待审核
				auditInfo.setnDeptNo(CompareFieldsUtil.getFieldValue(oldObj, "nDeptNo", Integer.class));
				auditInfo.setsShortName(CompareFieldsUtil.getFieldValue(oldObj, "sShortName", String.class));
				auditInfo.setsFullName(CompareFieldsUtil.getFieldValue(oldObj, "sFullName", String.class));
				auditInfo.setsDeptCode(CompareFieldsUtil.getFieldValue(oldObj, "sDeptCode", String.class));

				// 循环插入数据
				int count = auditInfoMapper.insert(auditInfo);
				if (count < 1) {
					isAllSuccess = false;
					logger.error("审核信息表插入失败：" + auditInfo.toString());
					throw new RuntimeException("审核信息表插入失败!失败数据：" + auditInfo.toString());
				} else {
					logger.info("审核信息表插入成功：" + auditInfo.toString());
				}
			}
		}

		return isAllSuccess;
	}

	/**
	 * 更新审核状态
	 * 
	 * @see com.hgl.recruitms.service.AuditInfoService#updateAuditStatus(java.util.List,
	 *      java.util.List, com.hgl.recruitms.enums.AuditStatusEnum,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateAuditStatus(List<T> oldtList, List<Integer> nAuditNoList, AuditStatusEnum auditStatus,
			List<Integer> nFundNoList,String sOperatorNo, String sOperator) {
		// 审核状态为空
		if (StringUtils.isEmpty(auditStatus)) {
			throw new IllegalArgumentException("审核状态为空");
		}

		// 当审核状态为不通过
		if (auditStatus.equals(AuditStatusEnum.REFUSE)) {
			// 根据审核ID查询数据
			AuditInfoExample example = new AuditInfoExample();
			example.createCriteria().andNAuditNoIn(nAuditNoList);
			List<Integer> nAuditNos = new ArrayList<Integer>(); // 用于存放类型为修改内容的审核数据ID
			// 更新数据
			AuditInfo auditInfo = new AuditInfo();
			auditInfo.setsStatus(AuditStatusEnum.REFUSE.getCode());
			auditInfo.setdOperateTime(new Date()); // 审核时间
			auditInfo.setsOperatorNo(sOperatorNo); // 审核人ID
			auditInfo.setsOperator(sOperator); // 审核人
			example = new AuditInfoExample();
			if (CollectionUtils.isNotEmpty(nAuditNos)) { // 处理修改内容数据
				example.or().andNAuditNoIn(nAuditNos);
			}
			int count = auditInfoMapper.updateByExampleSelective(auditInfo, example);

			return count > 0 ? true : false;
		}

		// 以下是审核通过操作

		// 先修改审核状态为通过，后面判断审核状态种类需要
		AuditInfoExample example = new AuditInfoExample();
		example.createCriteria().andNAuditNoIn(nAuditNoList).andSStatusEqualTo(AuditStatusEnum.AUDIT.getCode());
		AuditInfo updateAuditStatus = new AuditInfo();
		updateAuditStatus.setsStatus(AuditStatusEnum.PASS.getCode()); // 审核通过
		updateAuditStatus.setdOperateTime(new Date()); // 审核时间
		updateAuditStatus.setsOperatorNo(sOperatorNo); // 审核人ID
		updateAuditStatus.setsOperator(sOperator); // 审核人
		auditInfoMapper.updateByExampleSelective(updateAuditStatus, example);

		/***
		 * 需求为： 1.同组数据（院系专业内部编码和业务类型一致），一条不通过，同组数据全部不通过 2.只有当同组数据全部通过后才进行院系专业信息更新操作
		 * 3.修改内容通过一条更新一条 4.开始运作一条通过同组数据全部通过
		 ***/
		// 根据院系专业内部编码和是否最新条件查询数据
		example = new AuditInfoExample();
		example.setOrderByClause("D_CREATE_TIME"); // 为了业务类型为修改内容的审核批量通过时，有可能存在对同一个院系专业的同个字段进行多次通过，按最新的进行更新
		example.createCriteria().andNDeptNoIn(nFundNoList);
		List<AuditInfo> auditInfoList = auditInfoMapper.selectByExample(example);
		List<Integer> updateToPassauditInfoList = new ArrayList<Integer>(); // 用于保存需要进行更新为审核通过的审核ID
		// 遍历每一条审核信息数据并为要返回的泛型T对象设值，再给调用者进行更新
		for (AuditInfo auditInfo : auditInfoList) {
			T t = null;
			for (T oldT : oldtList) {
				if (CompareFieldsUtil.getFieldValue(oldT, "nDeptNo", Integer.class).equals(auditInfo.getnDeptNo())) {
					t = oldT;
					break;
				}
			}

			if (t == null) {
				throw new IllegalArgumentException("找不到院系专业内部编码为" + auditInfo.getnDeptNo() + "的对象");
			}

			// 设置要修改的属性
			String sModifyItemid = auditInfo.getsModifyItemid(); // 获取要修改的属性名
			String sAfterModify = auditInfo.getsAfterModify(); // 要修改属性的值
			CompareFieldsUtil.setField(t, sModifyItemid, sAfterModify); // 设置修改的属性值
		}

		if (!CollectionUtils.isEmpty(updateToPassauditInfoList)) {
			// 将数据全部置为通过
			example = new AuditInfoExample();
			example.createCriteria().andNAuditNoIn(updateToPassauditInfoList)
					.andSStatusEqualTo(AuditStatusEnum.AUDIT.getCode());
			auditInfoMapper.updateByExampleSelective(updateAuditStatus, example);
		}

		// 修改数据为旧数据
		if (!CollectionUtils.isEmpty(auditInfoList)) {
			List<Integer> nAuditNos = auditInfoList.stream().map(AuditInfo::getnAuditNo).collect(Collectors.toList());
			example = new AuditInfoExample();
			example.createCriteria().andNAuditNoIn(nAuditNos);
			updateAuditStatus = new AuditInfo();
			auditInfoMapper.updateByExampleSelective(updateAuditStatus, example);
		}

		logger.info("返回进行院系专业信息修改的List对象：" + oldtList);

		return true;
	}

	@Override
	public PageInfo<AuditInfo> listAuditPage(Integer pageIndex, Integer pageSize, String sDeptCode, String sFullName,
			String sStatus) {
		PageHelper.startPage(pageIndex, pageSize);
		List<AuditInfo> auditList = auditInfoMapper.listAuditPage(sDeptCode, sFullName, sStatus);

		// 获取字典数据
		String dictionary = "sRegion";
		HashMap<String, List<Dictionary>> dictMap = dictionaryService.getDictMapByItemCodes(null);

		// 遍历循环设置修改前，修改后返回显示值
		for (AuditInfo auditInfo : auditList) {
			String sModifyItemid = auditInfo.getsModifyItemid();

			if (dictionary.contains(sModifyItemid) && dictMap != null && dictMap.size() > 0) { // 从字典转换
				if ("sRegion".equals(sModifyItemid)) {
					dictValueChange(auditInfo, dictMap, "College");
				}
			}
		}
		return new PageInfo<>(auditList);
	}

	public void dictValueChange(AuditInfo auditInfo, HashMap<String, List<Dictionary>> dictMap, String sItemCode) {
		if (!StringUtils.isEmpty(auditInfo.getsBeforeModify())) {
			List<Dictionary> dictList = dictMap.get(sItemCode);

			if (CollectionUtils.isNotEmpty(dictList)) {
				for (Dictionary dict : dictList) {
					if (auditInfo.getsBeforeModify().equals(dict.getsItemKey())) {
						auditInfo.setsBeforeModify(dict.getsItemValue());
					}
				}
			}
		}
		if (!StringUtils.isEmpty(auditInfo.getsAfterModify())) {
			List<Dictionary> dictList = dictMap.get(sItemCode);

			if (CollectionUtils.isNotEmpty(dictList)) {
				for (Dictionary dict : dictList) {
					if (auditInfo.getsAfterModify().equals(dict.getsItemKey())) {
						auditInfo.setsAfterModify(dict.getsItemValue());
					}
				}
			}
		}
	}

	/**
	 * 获取审核通过的数据
	 * 
	 * @see com.hgl.recruitms.service.AuditInfoService#getPassAuditListByStatus(java.util.List)
	 */
	@Override
	public List<AuditInfo> getPassAuditListByStatus(List<Integer> sAuditNoList) {
		AuditInfoExample auditExample = new AuditInfoExample();
		auditExample.createCriteria().andNAuditNoIn(sAuditNoList).andSStatusEqualTo(AuditStatusEnum.PASS.getCode());

		List<AuditInfo> list = auditInfoMapper.selectByExample(auditExample);
		return list;
	}

	@Override
	public Account selectBysUserName(String sUsername) {
		AccountExample example = new AccountExample();
		example.createCriteria().andSUsernameEqualTo(sUsername);
		List<Account> accounts = accountMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(accounts)) {
			throw new RuntimeException("查询账号信息失败！请联系管理员..."+sUsername);
		}
		return accounts.get(0);
	}
}
