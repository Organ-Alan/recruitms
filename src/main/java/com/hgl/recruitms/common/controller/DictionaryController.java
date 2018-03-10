package com.hgl.recruitms.common.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.common.controller.response.CommonResponseObject;
import com.hgl.recruitms.common.controller.response.ErrorEnum;
import com.hgl.recruitms.common.web.restful.response.ResponseObject;
import com.hgl.recruitms.model.Dictionary;
import com.hgl.recruitms.service.DictionaryService;


/**  
 * ClassName: DictionaryController <br/>   
 * Description：字典组装所有的字典编码，循环查询字典值，然后返回给前端
 * @author huanggl  
 * @version   
 * Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.  
 */
@RestController
@RequestMapping("/admin")
public class DictionaryController {
	static Logger logger = LoggerFactory.getLogger(DictionaryController.class);

	@Autowired
	private CommonResponseObject builder;

	@Autowired
	private DictionaryService dictionaryService;

	/**
	 * getDictionarys:(根据字典编码（多个用逗号隔开），IN获取字典值). <br/>
	 * 
	 * @author huanggl
	 * @param sItemNos
	 * @return
	 */
	@RequestMapping(value = "/itemNo", method = { RequestMethod.GET })
	public ResponseObject<?> getDictionaryList(HttpServletResponse response,HttpServletRequest request,String sItemNos) {
		List<String> itemNoList = new ArrayList<String>();
		// 使用String工具解析sItemNos字符串.
		if (StringUtils.hasText(sItemNos)) {
			itemNoList = Arrays.asList(sItemNos.split(","));
		}
		request.getSession().setAttribute("itemNoList", itemNoList);
		return builder.success(dictionaryService.getDictMapByItemCodes(itemNoList));
	}

	/**
	 * listPageDictionary:分页查询字典信息. <br/>
	 * 
	 * @author huanggl
	 * @param pageIndex
	 *            当前页
	 * @param pageSize
	 *            当前页数据条数
	 * @param sItemValue
	 *            字典值
	 * @param sItemCode
	 *            字典编码
	 * @return
	 */
	@RequestMapping(value = "/listDictionarys", method = { RequestMethod.GET })
	public ModelAndView listPageDictionary(HttpServletResponse response,HttpServletRequest request,@RequestParam Integer pageIndex, @RequestParam Integer pageSize,
			String sItemValue, String sItemCode) {
		if (pageIndex == null || pageSize == null) {
			return new ModelAndView("errorPage.jsp");
		}
		PageInfo<Dictionary> pageInfo = dictionaryService.listDictionaryByNameAndCode(pageIndex, pageSize,
				sItemValue, sItemCode);
		request.getSession().setAttribute("listDictionarys", pageInfo);
		return new ModelAndView("dictionaryList.jsp");
	}

	/**
	 * getDictBynDictNo:根据字典编码获取字典信息. <br/>
	 * 
	 * @author huanggl
	 * @param nDictNo
	 * @return
	 */
	@RequestMapping(value = "/dictionary/{nDictNo}", method = { RequestMethod.GET })
	public ResponseObject<?> getDictBynDictNo(@PathVariable Integer nDictNo) {
		if (nDictNo == null) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "字典内部" + nDictNo + "错误！");
		}
		return builder.success(dictionaryService.getDictBynDictNo(nDictNo));
	}

	/**
	 * insertDictInfo:新增字典信息. <br/>
	 * 
	 * @author huanggl
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/dictionary", method = { RequestMethod.POST })
	public ResponseObject<?> insertDictInfo(@RequestBody Dictionary dictionary) {
		logger.info("需要新增的字典信息：{}", dictionary);
		if (dictionary == null) {// 新增信息为空
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "请求对象出错（" + dictionary + "）");
		}
		dictionary.setcValidFlag("1");
		boolean isSeccess = dictionaryService.insertDictInfo(dictionary);
		if (isSeccess) {
			return builder.success(dictionary);
		} else {
			return builder.error(ErrorEnum.NullPointer.getErrorCode(), "无法添加字典信息（" + dictionary + "）,请重新尝试！");
		}
	}

	/**
	 * updateDictInfo:更新字典信息. <br/>
	 * 
	 * @author huanggl
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/updateDictionary", method = { RequestMethod.POST })
	public ResponseObject<?> updateDictInfo(@RequestBody Dictionary dictionary) {
		logger.info("需要更新的字典信息：{}", dictionary.getnDictNo());
		boolean isSuccess = dictionaryService.updateDictInfo(dictionary);
		if (isSuccess) {
			return builder.success(dictionary);
		} else {
			return builder.error(ErrorEnum.NullPointer.getErrorCode(), "无法更新字典信息（" + dictionary + "）,请重新尝试！");
		}
	}

	/**
	 * delDictInfo:根据nDictNo删除字典信息. <br/>
	 * 
	 * @author huanggl
	 * @param nDictNo
	 * @return
	 */
	@RequestMapping(value = "/delDictionary/{nDictNo}", method = { RequestMethod.POST })
	public ResponseObject<?> delDictInfo(@PathVariable Integer nDictNo) {
		logger.info("需要更新的字典信息：{}", nDictNo);
		boolean isSuccess = dictionaryService.delDictInfo(nDictNo);
		if (isSuccess) {
			return builder.success(isSuccess);
		} else {
			return builder.error(-1, "删除字典信息失败，请重新尝试！");
		}
	}
}
