package com.hgl.recruitms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.enums.AuditStatusEnum;
import com.hgl.recruitms.model.Account;
import com.hgl.recruitms.model.AuditInfo;

/**
 * ClassName: AccountService <br/>
 * Description：公共模块业务逻辑接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
public interface CommonService<T> {

	/**
	 * checkLogin:登录校验. <br/>
	 * 
	 * @author huanggl
	 * @param sUsername
	 * @param sPassword
	 * @return
	 */
	boolean checkLogin(String sUsername, String sPassword);

	/**  
	 * selectBysUserName:通过账户名查询 <br/>  
	 * @author huanggl
	 * @param sUsername
	 * @return  
	 */
	Account selectBysUserName(String sUsername);
	/**
	 * checkDiffAndInsert:(比较两个对象的属性值，获取不同属性对审核信息表进行批量插入，全部插入成功返回true，否则false，支持忽略某些属性).
	 * <br/>
	 * 
	 * @author huanggl
	 * @param newObj
	 *            旧对象
	 * @param OldObj
	 *            新对象
	 * @param ignore
	 *            忽略属性，多个用逗号隔开
	 * @param sCreatorNo
	 *            创建人ID
	 * @param sCreator
	 *            创建人
	 * @return 所有数据插入成功返回true，否则false
	 */
	boolean checkDiffAndInsert(T oldObj, T newObj, List<String> ignore, String sCreatorNo, String sCreator);

	/**
	 * PublicCheckDiffAndInsert:(针对院系专业的自动审核通过，比较两个对象的属性值，获取不同属性对审核信息表进行批量插入，全部插入成功返回true，否则false，支持忽略某些属性).
	 * <br/>
	 * 
	 * @author huanggl
	 * @param oldObj
	 *            旧对象
	 * @param newObj
	 *            新对象
	 * @param ignore
	 *            忽略属性，多个用逗号隔开
	 * @param sCreatorNo
	 *            创建人ID
	 * @param sCreator
	 *            创建人
	 * @return
	 */
	boolean PublicCheckDiffAndInsert(T oldObj, T newObj, List<String> ignore, String sCreatorNo, String sCreator);

	/**
	 * updateAuditStatus:(审核通过或不通过操作). <br/>
	 * 
	 * @author huanggl
	 * @param oldtList
	 *            旧院系专业对象数组
	 * @param sAuditNoList
	 *            审核ID数组
	 * @param auditStatus
	 *            审核状态
	 * @param sTypeNFundNoMap
	 *            需要进行判断赋值的院系专业代码，
	 * @param sOperatorNo
	 *            审核人ID
	 * @param sOperator
	 *            审核人
	 * @return
	 */
	boolean updateAuditStatus(List<T> oldtList, List<Integer> sAuditNoList, AuditStatusEnum auditStatus,
			List<Integer> nFundNoList, String sOperatorNo, String sOperator);

	/**
	 * update:(修改审核状态，返回需要进行修改的List对象). <br/>
	 * 
	 * @author huanggl
	 * @param oldtList
	 *            数据库旧数据集合
	 * @param sAuditNoList
	 *            审核信息主键ID集合
	 * @param auditStatus
	 *            审核状态枚举
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	// boolean updateAuditStatus(List<T> oldtList, List<Integer> sAuditNoList,
	// AuditStatusEnum auditStatus);

	/**
	 * listAuditPage:(审核信息分页展示). <br/>
	 * 
	 * @author huanggl
	 * @param pageIndex
	 *            当前页码
	 * @param pageSize
	 *            每页大小
	 * @param sDeptCode
	 *            院系专业代码
	 * @param sFullName
	 *            院系专业全称
	 * @param sStatus
	 *            审核状态
	 * @return
	 */
	PageInfo<AuditInfo> listAuditPage(Integer pageIndex, Integer pageSize, String sDeptCode, String sFullName,
			String sStatus);

	/**
	 * getPassAuditListByStatus:(根据审核主键List查询符合已审核通过的数据). <br/>
	 * 
	 * @author huanggl
	 * @param sAuditNoList
	 *            审核主键
	 * @return
	 */
	List<AuditInfo> getPassAuditListByStatus(List<Integer> sAuditNoList);
	
}
