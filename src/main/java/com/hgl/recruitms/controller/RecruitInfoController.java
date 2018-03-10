package com.hgl.recruitms.controller;

import java.io.IOException;
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
import com.hgl.recruitms.common.controller.response.ErrorEnum;
import com.hgl.recruitms.common.util.ExportUtil;
import com.hgl.recruitms.common.util.JsonUtil;
import com.hgl.recruitms.common.web.restful.response.CommonResponseBuilder;
import com.hgl.recruitms.common.web.restful.response.ResponseObject;
import com.hgl.recruitms.enums.TBHeaderEnum;
import com.hgl.recruitms.model.RecruitInfo;
import com.hgl.recruitms.service.RecruitInfoService;

/**
 * ClassName: RecruitInfoController <br/>
 * Description：新生信息控制层接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@RestController
@RequestMapping("/admin")
public class RecruitInfoController {
	static Logger logger = LoggerFactory.getLogger(RecruitInfoController.class);
	@Autowired
	private CommonResponseBuilder builder;

	@Autowired
	private RecruitInfoService recruitInfoService;

	@RequestMapping(value = "/listRecruitInfos", method = { RequestMethod.GET })
	public ModelAndView listPageRecruitInfo(HttpServletResponse response,HttpServletRequest request,@RequestParam Integer pageIndex, @RequestParam Integer pageSize,
			String sStudentNo, String sStudentName, String sAdmitedMajor, String sGrade, String sPayFlag,
			String sStatus) {
		request.getSession().setAttribute("studentInfoList", null);
		if (pageIndex == null || pageSize == null) {
			return new ModelAndView("errorPage.jsp");
		}
		PageInfo<RecruitInfo> pageInfo = recruitInfoService.listRecruitInfos(pageIndex, pageSize, sStudentNo,
				sStudentName, sAdmitedMajor, sGrade, sPayFlag, sStatus);
		logger.debug(JsonUtil.serialize(pageInfo));
		request.getSession().setAttribute("recruitInfoList", pageInfo);
		return new ModelAndView("recruitInfoList.jsp","pageInfos",pageInfo);
	}
	
	@RequestMapping(value = "/listRecruitAuditInfos", method = { RequestMethod.GET })
	public ModelAndView listRecruitAuditInfos(HttpServletResponse response,HttpServletRequest request,@RequestParam Integer pageIndex, @RequestParam Integer pageSize,
			String sStudentNo, String sStudentName, String sAdmitedMajor, String sGrade, String sPayFlag,
			String sStatus) {
		request.getSession().setAttribute("auditInfosList", null);
		if (pageIndex == null || pageSize == null) {
			return new ModelAndView("errorPage.jsp");
		}
		PageInfo<RecruitInfo> pageInfo = recruitInfoService.listRecruitInfos(pageIndex, pageSize, sStudentNo,
				sStudentName, sAdmitedMajor, sGrade, sPayFlag, sStatus);
		request.getSession().setAttribute("auditInfosList", pageInfo);
		logger.debug(JsonUtil.serialize(pageInfo));
		return new ModelAndView("enrollmentAudit.jsp");
	}

	/**
	 * getRecruitInfoById:根据新生信息编码获取新生信息. <br/>
	 * 
	 * @author huanggl
	 * @param nStudentId
	 * @return
	 */
	@RequestMapping(value = "/recruitInfo/{nStudentId}", method = { RequestMethod.GET })
	public ResponseObject<?> getRecruitInfoBynQaId(HttpServletResponse response,HttpServletRequest request,@PathVariable Integer nStudentId) {
		if (nStudentId == null) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "新生信息内部编码" + nStudentId + "错误！");
		}
		if(request.getSession().getAttribute("recruitDetailInfo") == null) {
			request.getSession().removeAttribute("recruitDetailInfo");
		}
		request.getSession().setAttribute("recruitDetailInfo", recruitInfoService.getRecruitInfo(nStudentId));
		logger.debug(JsonUtil.serialize(recruitInfoService.getRecruitInfo(nStudentId)));
		return builder.success(recruitInfoService.getRecruitInfo(nStudentId));
	}

	/**
	 * insertRecruitInfo:新增新生信息. <br/>
	 * 
	 * @author huanggl
	 * @param recruitInfo
	 * @return
	 */
	@RequestMapping(value = "/recruitInfo", method = { RequestMethod.POST })
	public ModelAndView insertRecruitInfo(@RequestBody RecruitInfo recruitInfo) {
		logger.info("需要新增新生信息：{}", recruitInfo);
		if (recruitInfo == null) {// 新增信息为空
			return new ModelAndView("errorPage.jsp");
		}
		boolean isSeccess = recruitInfoService.insertRecruitInfo(recruitInfo);
		if (isSeccess) {
			return new ModelAndView("recruitInfoList.jsp");
		} else {
			return new ModelAndView("errorPage.jsp");
		}
	}

	/**
	 * updateRecruitInfo:修改新生信息，并且将其状态改为待审核 <br/>
	 * 
	 * @author huanggl
	 * @param recruitInfo
	 * @return
	 */
	@RequestMapping(value = "/updateRecruitInfo", method = { RequestMethod.POST })
	public ResponseObject<?> updateRecruitInfo(@RequestBody RecruitInfo recruitInfo) {
		logger.debug("更新内容为：{}" + recruitInfo.toString());
		boolean flag = recruitInfoService.updateRecruitInfo(recruitInfo);
		if (!flag) {
			return builder.error(-1, "更改出错！");
		}
		return builder.success(recruitInfo);
	}

	/**
	 * updateRevisonreview:审核通过或不通过. <br/>
	 * 
	 * @author huanggl
	 * @param recruitInfo
	 * @return
	 */
	@RequestMapping(value = "/RevisonreviewRecruitInfo", method = { RequestMethod.POST })
	public ModelAndView updateRevisonreview(@RequestParam Integer nStudentId,
			@RequestParam String action) throws IndexOutOfBoundsException {
		// 判断集合是否为空
		if (nStudentId==null) {
			return new ModelAndView("errorPage.jsp");
		}
		// 批量审核新生信息
		boolean flag = recruitInfoService.updateInfoStatus(nStudentId, action);
		if (!flag) {
			return new ModelAndView("errorPage.jsp");
		}
		return new ModelAndView("enrollmentAudit.jsp");
	}

	/**
	 * countInfo:统计学生信息记录数,用来计算报到率. <br/>
	 * 
	 * @author huanggl
	 * @return
	 */
	@RequestMapping(value = "countRecruitInfo", method = { RequestMethod.GET })
	public ResponseObject<?> countInfo() {
		int count = recruitInfoService.accountRecruitStudent();
		return builder.success(count);
	}

	/**
	 * exportRecruitInfoList:根据查询条件导出新生信息. <br/>
	 * 
	 * @author huanggl
	 * @param request
	 * @param response
	 * @param sStudentNo 学号
	 * @param sStudentName 姓名
	 * @param sAdmitedMajor 录取专业
	 * @param sGrade 年级
	 * @param sPayFlag 是否缴费
	 * @param sStatus 审核状态
	 * @param nStudentIdList 勾选列表
	 * @param exportType 导出内容：新生信息 RecruitInfo
	 * @throws IOException
	 */
	@RequestMapping(value = "/export/recruitInfoList", method = { RequestMethod.GET })
	public void exportRecruitInfoList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String sStudentNo, @RequestParam String sStudentName, @RequestParam String sAdmitedMajor,
			@RequestParam String sGrade, @RequestParam String sPayFlag, @RequestParam String sStatus,
			@RequestParam List<Integer> nStudentIdList) throws IOException {
		String  exportType = TBHeaderEnum.RECRUITINFO.getName();
		// 根据条件获取新生列表
		List<List<String>> table = recruitInfoService.exportRecruitInfo(sStudentNo.trim(), sStudentName.trim(),
				sAdmitedMajor.trim(), sGrade.trim(), sPayFlag.trim(), sStatus.trim(), nStudentIdList,
				exportType.trim());

		sStudentNo = StringUtils.hasText(sStudentNo) ? sStudentNo.trim() : "";
		sStudentName = StringUtils.hasText(sStudentName) ? sStudentName.trim() : "";
		String fileName = "新生信息列表-";
		// 设置列宽度
		int[] sheetWidth = { 5000, 5000, 5000, 5000, 5000, 5000, 4000 };
		ExportUtil.export(table, fileName, response, sheetWidth);// 根据查询得到的列表生成excel

		logger.info("导出完成！{},{},{},{},{},{},{}", sStudentNo, sStudentName, sAdmitedMajor, sGrade, sPayFlag, sStatus,
				nStudentIdList);
	}
}
