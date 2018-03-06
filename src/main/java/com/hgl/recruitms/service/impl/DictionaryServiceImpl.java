package com.hgl.recruitms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.dao.DictionaryMapper;
import com.hgl.recruitms.enums.DataStatusEnum;
import com.hgl.recruitms.model.Dictionary;
import com.hgl.recruitms.model.DictionaryExample;
import com.hgl.recruitms.model.DictionaryExample.Criteria;
import com.hgl.recruitms.service.DictionaryService;


/**  
 * ClassName: DictionaryServiceImpl <br/>  
 * date: 2017年11月14日 上午11:04:13 <br/>  
 * Description：根据字典编码查询字典值
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
	static Logger logger = LoggerFactory.getLogger(DictionaryServiceImpl.class);

	@Autowired
	private DictionaryMapper dictionaryMapper;

	@Override
	public HashMap<String, List<Dictionary>> getDictMapByItemCodes(List<String> itemNoList) {
		DictionaryExample example = new DictionaryExample();
		Criteria criteria = example.createCriteria();
		List<Dictionary> results = null; // 存放查询结果集
		HashMap<String, List<Dictionary>> resultMap = new HashMap<>();// 使用Map存放不同字典编码的字典值数组
		if (CollectionUtils.isNotEmpty(itemNoList)) {
			// 使用IN函数查询字典表
			criteria.andSItemCodeIn(itemNoList);
		}
		//过滤已经失效的字典数据
		criteria.andCValidFlagEqualTo(DataStatusEnum.VALID.getCode());
		// 返回全量字典值
		results = dictionaryMapper.selectByExample(example);

		// 根据字典编码，格式化全量字典值
		for (Dictionary Dictionary : results) {
			// 获取字典编码，如user_type等
			String sItemCode = Dictionary.getsItemCode();
			logger.debug("sItemCode:", sItemCode);
			// 把不同字典编码的字典值组装成List返回前端遍历展示
			List<Dictionary> dictList = resultMap.get(sItemCode);
			if (CollectionUtils.isEmpty(dictList)) {
				dictList = new ArrayList<Dictionary>();
			}
			dictList.add(Dictionary);
			resultMap.put(sItemCode, dictList);
		}
		return resultMap;
	}

	/**
	 *  获取选中字典信息.
	 * 
	 * @see com.DictionaryService.pms.common.sys.service.DictionaryService#getDictBynDictNo(java.lang.Integer)
	 */
	@Override
	public Dictionary getDictBynDictNo(Integer nDictNo) {
		if (nDictNo == null) {
			throw new IllegalArgumentException("参数错误！字典编码不能为空");
		}
		DictionaryExample example = new DictionaryExample();
		example.createCriteria().andNDictNoEqualTo(nDictNo);
		List<Dictionary> results = dictionaryMapper.selectByExample(example);
		if (results == null || CollectionUtils.isEmpty(results)) {
			return null;
		}
		return results.get(0);
	}

	/**
	 *  新增字典信息.
	 * 
	 * @see com.DictionaryService.pms.common.sys.service.DictionaryService#insertDictInfo(com.efunds.pms.common.sys.model.Dictionary)
	 */
	@Override
	public boolean insertDictInfo(Dictionary dictionary) {
		int isSuccess = 0;// 插入是否成功isSuccess
		if (dictionary == null) {
			throw new RuntimeException("新增字典信息失败,字典信息为空！");
		}
		isSuccess = dictionaryMapper.insert(dictionary);
		return isSuccess > 0;
	}

	/**
	 *  编辑字典信息.
	 * 
	 * @see com.DictionaryService.pms.common.sys.service.DictionaryService#updateDictInfo(com.efunds.pms.common.sys.model.Dictionary)
	 */
	@Override
	public boolean updateDictInfo(Dictionary dictionary) {
		// 字典信息在修改时存在信息不存在的异常情况
		if (dictionary.getnDictNo() == null) {
			logger.error("新增字典失败，字典信息不存在！");
			throw new RuntimeException("新增字典信息失败,字典信息为空！");
		}
		int isSuccess = dictionaryMapper.updateByPrimaryKeySelective(dictionary);
		return isSuccess > 0;
	}

	/**
	 *  根据字典内部编码删除字典信息(软删除，修改字典数据状态).
	 * 
	 * @see com.DictionaryService.pms.common.sys.service.DictionaryService#delDictInfo(com.efunds.pms.common.sys.model.Dictionary)
	 */
	@Override
	public boolean delDictInfo(Integer nDictNo) {
		// 修改字典表的数据状态sValidFlag值为删除状态
		Dictionary dictionary = dictionaryMapper.selectByPrimaryKey(nDictNo);
		System.out.println(dictionary.getcValidFlag());
		dictionary.setcValidFlag(DataStatusEnum.INVALID.getCode());
		int isSuccess = dictionaryMapper.updateByPrimaryKeySelective(dictionary);
		return isSuccess > 0;
	}

	/**
	 *  分页查询字典信息列表.
	 * 
	 * @see com.DictionaryService.pms.common.sys.service.DictionaryService#listDictionaryByNameAndCode(java.lang.Integer,
	 *      java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public PageInfo<Dictionary> listDictionaryByNameAndCode(Integer pageIndex, Integer pageSize, String sItemValue,
			String sItemCode) {
		// 拼装条件
		DictionaryExample example = new DictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andNDictNoIsNotNull();
		// 过滤数据状态为删除状态的字典
		criteria.andCValidFlagEqualTo(DataStatusEnum.VALID.getCode());
		logger.debug("获取字典信息列表：字典名称" + sItemValue + "   字典编码：" + sItemCode);
		// 模糊查询
		if (StringUtils.hasText(sItemValue)) {
			criteria.andSItemValueLike("%" + sItemValue + "%");
		}
		if (StringUtils.hasText(sItemCode)) {
			criteria.andSItemCodeLike("%" + sItemCode + "%");
		}
		example.setOrderByClause(" S_ITEM_CODE,S_SORT_NO ASC ");
		logger.debug("字典信息列表当前显示第" + pageIndex + "页且当前页面展示的条数" + pageSize);
		// 调用静态方法，设置分页参数即可，随后的第一次查询的sql语句会自动被分页插件改装成带有分页查询的sql语句
		PageHelper.startPage(pageIndex, pageSize);
		// 获取满足条件的产品改造进度表的数据。
		List<Dictionary> dictList = dictionaryMapper.selectByExample(example);
		return new PageInfo<Dictionary>(dictList);
	}

	/**
	 *  根据字典编码及序号定位到具体字典值.
	 * 
	 * @see com.DictionaryService.pms.common.sys.service.DictionaryService#getDicByItemCodeAndSortNo(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public Dictionary getDicByItemCodeAndKey(String sItemCode, String sItemKey) {
		DictionaryExample example = new DictionaryExample();
		example.createCriteria().andSItemCodeEqualTo(sItemCode).andSItemKeyEqualTo(sItemKey);
		List<Dictionary> dictionary = dictionaryMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(dictionary)) {
			return null;
		}
		return dictionary.get(0);
	}

	@Override
	public List<Dictionary> getDictByItemCode(String sItemCode) {
		if (StringUtils.isEmpty(sItemCode)) {
			throw new NullPointerException("字典编码不能为空！");
		}
		DictionaryExample example = new DictionaryExample();
		example.createCriteria().andSItemCodeEqualTo(sItemCode);
		return dictionaryMapper.selectByExample(example);
	}
}
