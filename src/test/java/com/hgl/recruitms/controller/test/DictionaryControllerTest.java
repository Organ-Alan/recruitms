package com.hgl.recruitms.controller.test;

import java.util.HashMap;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hgl.recruitms.common.test.BaseSpringMvcTest;
import com.hgl.recruitms.common.util.JsonUtil;
import com.hgl.recruitms.model.Dictionary;


/**
 * ClassName: DictionaryControllerTest <br/>
 * date: 2017年12月23日 下午2:55:26 <br/>
 * Description：字典维护接口Controller层进行测试
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
public class DictionaryControllerTest extends BaseSpringMvcTest {

	/**
	 * getDictionaryInfo:获取每一个字典编码的字典信息. <br/>
	 * 
	 * @author huanggl
	 * @throws Exception
	 */
	@Test
	public void getDictionaryInfo() throws Exception {
		HashMap<String, Dictionary> map = new HashMap<>();
		perform(MockMvcRequestBuilders.get("/recruitms/v1/common/dict/itemNo").param("sItemNos","")
				.contentType(MediaType.APPLICATION_JSON).content(JsonUtil.serialize(map)));
	}

	/**
	 * listDictionaryByNameAndCode:分页查询字典信息列表. <br/>
	 * 
	 * @author huanggl
	 * @throws Exception
	 */
	@Test
	public void listDictionaryByNameAndCode() throws Exception {
		String pageIndex = "1";
		String pageSize = "10";
		String sItemValue = "";
		String sItemCode = "USER";
		perform(MockMvcRequestBuilders.get("/recruitms/v1/common/dict/listDictionarys").param("pageIndex", pageIndex)
				.param("pageSize", pageSize).param("sItemValue", sItemValue).param("sItemCode", sItemCode)
				.contentType(MediaType.APPLICATION_JSON));
	}

	/**
	 * getDictBynDictNo:根据字典内部编码查询字典信息. <br/>
	 * 
	 * @author huanggl
	 * @throws Exception
	 */
	@Test
	public void getDictBynDictNo() throws Exception {
		String nDictNo = "35";
		perform(MockMvcRequestBuilders.get("/recruitms/v1/common/dict/dictionary/"+nDictNo)
				.contentType(MediaType.APPLICATION_JSON));
	}

	/**  
	 * insertDictInfo:新增字典信息. <br/>  
	 * @author huanggl
	 * @throws Exception  
	 */
	@Test
	public void insertDictInfo() throws Exception {
		// 创设测试字典值，在删除时也用此测试数据，以免造成字典表数据混乱
		Dictionary dictionary = new Dictionary();
		dictionary.setsItemCode("Test");
		dictionary.setsItemKey("test");
		dictionary.setsSortNo("1");
		dictionary.setsItemValue("Test");
		dictionary.setcValidFlag("1");
		perform(MockMvcRequestBuilders.post("/recruitms/v1/common/dict/dictionary")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.serialize(dictionary)));
	}
	
	/**  
	 * updateDictInfo:修改字典信息. <br/>  
	 * @author huanggl
	 * @throws Exception  
	 */
	@Test
	public void updateDictInfo() throws Exception {
		// 创设测试字典值，在删除时也用此测试数据，以免造成字典表数据混乱
		Dictionary Dictionary = new Dictionary();
		Dictionary.setnDictNo(125);
		Dictionary.setsItemCode("Test2");
		perform(MockMvcRequestBuilders.put("/recruitms/v1/common/dict/dictionary")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.serialize(Dictionary)));
	}
	
	/**  
	 * delDictInfo:删除字典信息. <br/>  
	 * @author huanggl
	 * @throws Exception  
	 */
	@Test
	public void delDictInfo() throws Exception {
		// 创设测试字典值，在删除时也用此测试数据，以免造成字典表数据混乱
		String nDitNo = "126";
		perform(MockMvcRequestBuilders.put("/recruitms/v1/common/dict/dictionary/"+nDitNo)
				.contentType(MediaType.APPLICATION_JSON));
	}
}
