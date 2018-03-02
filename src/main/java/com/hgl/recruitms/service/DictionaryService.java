package com.hgl.recruitms.service;

import java.util.HashMap;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.model.Dictionary;


/**  
 * ClassName: DictionaryService <br/>  
 * date: 2017年11月14日 上午11:04:53 <br/>  
 * Description：字典表相关
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public interface DictionaryService {
	
	/**  
	 * getDictMapByItemCodes:(根据字典编码，获取字典值。多个字典编码用逗号隔开). <br/>  
	 * @author huanggl
	 * @param itemCodeList
	 * 			字典编码List，如："FUND_CATEGORY,CAPITALPRO_TYPE"
	 * @return  
	 */
	HashMap<String, List<Dictionary>> getDictMapByItemCodes(List<String> itemCodeList);
		
	/**  
	 * listDictionaryByNameAndCode:(根据字典值、字典编码，获取全部字典信息，支持模糊查询). <br/>  
	 * @author huanggl
	 * @param sItemValue
	 * 			字典名称
	 * 		  sItemCode
	 * 			字典编码
	 * @return  
	 */
	PageInfo<Dictionary> listDictionaryByNameAndCode(Integer pageIndex, Integer pageSize,
			String sItemValue,String sItemCode);
	/**  
	 * getDictBynDictNo:(根据字典内部编码，获取字典信息). <br/>  
	 * @author huanggl
	 * @param nDictNo
	 * 		
	 * @return  
	 */
	Dictionary getDictBynDictNo(Integer nDictNo);
	
	/**  
	 * insertDictInfo:(增加字典信息). <br/>  
	 * @author huanggl
	 * @param dictionary
	 * 			字典对象
	 * @return  
	 */
	boolean insertDictInfo(Dictionary dictionary);
	
	/**  
	 * updateDictInfo:(更新字典信息). <br/>  
	 * @author huanggl
	 * @param dictionary
	 * 			字典对象
	 * @return  
	 */
	boolean updateDictInfo(Dictionary dictionary);
	
	/**  
	 * delDictInfo:(删除字典信息). <br/>  
	 * @author huanggl
	 * @param nDictNo
	 * 			字典主键
	 * @return  
	 */
	boolean delDictInfo(Integer nDictNo);
	
	/**  
	 * getDicByItemCodeAndSortNo:(获取字典值). <br/>  
	 * @author huanggl
	 * @param sItemCode
	 * 			字典编码
	 * @param sSortNo
	 * 			字典序号
	 * @return  
	 */
	Dictionary getDicByItemCodeAndKey(String sItemCode,String sItemKey);

	/**  
	 * getDictByItemCode:根据字典编码获取字典配置. <br/>  
	 * @author lqju  
	 * @param sItemCode
	 * @return  
	 */
	List<Dictionary> getDictByItemCode(String sItemCode);
}
