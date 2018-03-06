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
import com.hgl.recruitms.dao.QAInfoMapper;
import com.hgl.recruitms.enums.DataStatusEnum;
import com.hgl.recruitms.model.QAInfo;
import com.hgl.recruitms.model.QAInfoExample;
import com.hgl.recruitms.model.QAInfoExample.Criteria;
import com.hgl.recruitms.service.QAInfoService;

/**
 * ClassName: QAInfoServiceImpl <br/>
 * Description：答疑信息业务接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@Service
public class QAInfoServiceImpl implements QAInfoService {
	static Logger logger = LoggerFactory.getLogger(QAInfoServiceImpl.class);
	@Autowired
	private QAInfoMapper qaInfoMapper;

	@Override
	public boolean insertQAInfo(QAInfo qaInfo) {
		qaInfo.setdCreateTime(new Date());
		int count = qaInfoMapper.insert(qaInfo);
		logger.info("新增答疑信息:" + qaInfo.toString() + "，结果：" + (count > 0));
		return count > 0;
	}

	@Override
	public QAInfo getQAInfo(Integer nQaId) {
		QAInfo qaInfo = new QAInfo();
		QAInfoExample qaInfoExample = new QAInfoExample();
		// 拼装条件（产品内部编码）
		qaInfoExample.createCriteria().andNQaIdEqualTo(nQaId);
		List<QAInfo> qaInfoList = qaInfoMapper.selectByExample(qaInfoExample);
		if (qaInfoList != null && qaInfoList.size() > 0) {
			qaInfo = qaInfoList.get(0);// 获取答疑信息信息
		}
		return qaInfo;
	}

	@Override
	public boolean updateQAInfo(QAInfo qaInfo) {
		// 通过主键答疑信息编码进行修改
		int count = qaInfoMapper.updateByPrimaryKey(qaInfo);
		logger.debug("调用数据库修改答疑信息信息的条数为::" + count);
		// 当修改答疑信息信息失败时
		if (count < 1) {
			logger.error("修改基础信息失败,修改基础信息数据为：" + qaInfo.toString() + "，条件为:" + qaInfo.getnQaId());
			throw new RuntimeException("修改基础信息失败，抛出异常，事务回滚");
		}
		return count > 0;
	}

	/**
	 * listQAInfo:分页获取答疑信息 <br/>
	 * 
	 * @see com.hgl.recruitms.service.QAInfoService#listQAInfo(java.lang.Integer,
	 *      java.lang.Integer, java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public PageInfo<QAInfo> listQAInfos(Integer pageIndex, Integer pageSize, String sQuestion) {
		// 用于查询全部信息，判断是否需要查询全部的信息，包括已变更，已删除的产品信息
		logger.info("查询答疑信息列表：{},{},{},{},{},{},{},{}", pageIndex, pageSize, sQuestion);
		// 拼装条件
		QAInfoExample example = new QAInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andNQaIdIsNotNull();
		// 模糊查询
		if (StringUtils.hasText(sQuestion)) {
			criteria.andSQuestionLike("%" + sQuestion + "%");
		}
		example.setOrderByClause(" D_CREATE_TIME ASC ");
		logger.debug("答疑信息列表当前显示第" + pageIndex + "页且当前页面展示的条数" + pageSize);
		// 调用静态方法，设置分页参数即可，随后的第一次查询的sql语句会自动被分页插件改装成带有分页查询的sql语句
		PageHelper.startPage(pageIndex, pageSize);
		// 获取满足条件的数据
		List<QAInfo> qaInfos = qaInfoMapper.selectByExample(example);
		return new PageInfo<QAInfo>(qaInfos);
	}

	@Override
	public int accountQAInfo() {
		QAInfoExample example = new QAInfoExample();
		// 过滤无效的答疑信息
		example.createCriteria().andCValidFlagEqualTo(DataStatusEnum.INVALID.getCode());
		int count = (int) qaInfoMapper.countByExample(example);
		return count;
	}

	@Override
	public boolean delQAInfo(Integer nQaId) {
		// 修改答疑信息表的数据状态sValidFlag值为删除状态
		QAInfo qaInfo = qaInfoMapper.selectByPrimaryKey(nQaId);
		qaInfo.setcValidFlag(DataStatusEnum.INVALID.getCode());
		int isSuccess = qaInfoMapper.updateByPrimaryKeySelective(qaInfo);
		return isSuccess > 0;
	}

}
