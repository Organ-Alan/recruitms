package com.hgl.recruitms.service.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.common.test.BaseSpringContextTest;
import com.hgl.recruitms.common.web.util.JsonUtil;
import com.hgl.recruitms.model.Dictionary;
import com.hgl.recruitms.service.DictionaryService;


/**  
 * ClassName: DictionaryServiceTest <br/>  
 * date: 2017年11月14日 上午11:05:59 <br/>  
 * Description：测试字典查询接口相关操作
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public class CommonServiceTest extends BaseSpringContextTest {
	static Logger logger = LoggerFactory.getLogger(CommonServiceTest.class);
	@Autowired
	private DictionaryService dictionaryService;

	/**
	 * getDictListByItemNo:测试字典各个字典编码的信息. <br/>
	 * 
	 * @author huanggl
	 */
	@Test
	public void getDictListByItemNo() {
		List<String> itemNoList = new ArrayList<String>();
		itemNoList.add("user_type");
		HashMap<String, List<Dictionary>> list = dictionaryService.getDictMapByItemCodes(itemNoList);
		logger.debug(JsonUtil.serialize(list));
	}

	/**
	 * listDictionaryByNameAndCode:分页查询字典信息列表. <br/>
	 * 
	 * @author huanggl
	 */
	@Test
	public void listDictionaryByNameAndCode() {
		Integer pageIndex = 1;
		Integer pageSize = 10;
		String sItemValue = "";
		String sItemCode = "user";
		PageInfo<Dictionary> dictionarys = dictionaryService.listDictionaryByNameAndCode(pageIndex, pageSize, sItemValue, sItemCode);
		System.out.println(JsonUtil.serialize(dictionarys));
	}

	/**  
	 * getDictBynDictNo:根据字典内部编码获取字典值. <br/>  
	 * @author huanggl  
	 */
	@Test
	public void getDictBynDictNo() {
		Integer nDictNo = 68;
		Dictionary dictionary = dictionaryService.getDictBynDictNo(nDictNo);
		System.out.println(JsonUtil.serialize(dictionary));
	}
	
	/**  
	 * insertDictInfo:新增字典表信息. <br/>  
	 * @author huanggl  
	 */
	@Test
	public void insertDictInfo() {
		//创设测试字典值，在删除时也用此测试数据，以免造成字典表数据混乱
		Dictionary Dictionary = new Dictionary();
		Dictionary.setsItemCode("Test");
		Dictionary.setsItemKey("test");
		Dictionary.setsSortNo("test");
		Dictionary.setsItemValue("Test");
		Dictionary.setcValidFlag("1");
		System.out.println(JsonUtil.serialize(Dictionary));
		System.out.println(dictionaryService.insertDictInfo(Dictionary));
	}
	
	/**  
	 * updateDictInfo:修改字典表信息. <br/>  
	 * @author huanggl  
	 */
	@Test
	public void updateDictInfo() {
		//该部分测试只对test数据进行测试，以免造成字典表数据混乱
		Dictionary Dictionary = new Dictionary();
		Dictionary.setnDictNo(124);
		Dictionary.setsItemCode("Test2");
		System.out.println(dictionaryService.updateDictInfo(Dictionary));
	}
	
	/**  
	 * delDictInfo:删除字典表信息. <br/>  
	 * @author huanggl  
	 */
	@Test
	public void delDictInfo() {
		//删除必须只删除Test数据，以免造成字典表数据丢失
		System.out.println(dictionaryService.delDictInfo(124));
	}
	
	/**  
	 * getDicByItemCodeAndSortNo:通过字典编码及序号获取字典值. <br/>  
	 * @author huanggl  
	 */
	@Test 
	public void getDicByItemCodeAndSortNo() {
		String sItemCode = "FUND_CATEGORY";
		String sItemKey = "gp";
		Dictionary dictionary = dictionaryService.getDicByItemCodeAndKey(sItemCode, sItemKey);
		System.out.println(JsonUtil.serialize(dictionary));
	}
}
