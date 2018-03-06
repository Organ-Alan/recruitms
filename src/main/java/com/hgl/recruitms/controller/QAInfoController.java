package com.hgl.recruitms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.common.controller.response.ErrorEnum;
import com.hgl.recruitms.common.web.restful.response.CommonResponseBuilder;
import com.hgl.recruitms.common.web.restful.response.ResponseObject;
import com.hgl.recruitms.model.QAInfo;
import com.hgl.recruitms.service.QAInfoService;

/**
 * ClassName: QAInfoController <br/>
 * Description：答疑信息控制层接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@RestController
@RequestMapping("/{version}/QA")
public class QAInfoController {
	static Logger logger = LoggerFactory.getLogger(QAInfoController.class);
	@Autowired
	private CommonResponseBuilder builder;

	@Autowired
	private QAInfoService qaInfoService;

	@RequestMapping(value = "/listQAInfos", method = { RequestMethod.GET })
	public ResponseObject<?> listPageQAInfo(@RequestParam Integer pageIndex, @RequestParam Integer pageSize,
			String sQuestion) {
		if (pageIndex == null || pageSize == null) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "参数" + pageIndex + "、" + pageSize + "错误！");
		}
		PageInfo<QAInfo> pageInfo = qaInfoService.listQAInfos(pageIndex, pageSize, sQuestion);
		return builder.success(pageInfo);
	}

	/**
	 * getQAInfoBynQaId:根据答疑信息编码获取答疑信息. <br/>
	 * 
	 * @author huanggl
	 * @param nQaId
	 * @return
	 */
	@RequestMapping(value = "/qaInfo/{nQaId}", method = { RequestMethod.GET })
	public ResponseObject<?> getQAInfoBynQaId(@PathVariable Integer nQaId) {
		if (nQaId == null) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "答疑信息内部编码" + nQaId + "错误！");
		}
		return builder.success(qaInfoService.getQAInfo(nQaId));
	}

	/**
	 * insertQAInfo:新增答疑信息. <br/>
	 * 
	 * @author huanggl
	 * @param qaInfo
	 * @return
	 */
	@RequestMapping(value = "/qaInfo", method = { RequestMethod.POST })
	public ResponseObject<?> insertQAInfo(@RequestBody QAInfo qaInfo) {
		logger.info("需要新增答疑信息：{}", qaInfo);
		if (qaInfo == null) {// 新增信息为空
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "请求对象出错（" + qaInfo + "）");
		}
		boolean isSeccess = qaInfoService.insertQAInfo(qaInfo);
		if (isSeccess) {
			return builder.success(qaInfo);
		} else {
			return builder.error(ErrorEnum.NullPointer.getErrorCode(), "无法添加答疑信息（" + qaInfo + "）,请重新尝试！");
		}
	}

	/**
	 * delQAInfo:根据nQaId删除答疑信息. <br/>
	 * 
	 * @author huanggl
	 * @param nQaId
	 * @return
	 */
	@RequestMapping(value = "/qaInfo/{nQaId}", method = { RequestMethod.PUT })
	public ResponseObject<?> delQAInfo(@PathVariable Integer nQaId) {
		logger.info("需要更新的答疑信息：{}", nQaId);
		boolean isSuccess = qaInfoService.delQAInfo(nQaId);
		if (isSuccess) {
			return builder.success(isSuccess);
		} else {
			return builder.error(-1, "删除答疑信息失败，请重新尝试！");
		}
	}
	
	@RequestMapping(value = "/qaInfo",method = { RequestMethod.PUT})
	public ResponseObject<?> updateQAInfo(@RequestBody QAInfo qaInfo){
		logger.debug("更新内容为：{}"+qaInfo.toString());
		boolean flag = qaInfoService.updateQAInfo(qaInfo);
		if (!flag) {
			return builder.error(-1,"更改出错！");
		}	
		return builder.success(qaInfo);
	}
}
