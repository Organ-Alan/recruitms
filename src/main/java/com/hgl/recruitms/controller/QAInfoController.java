package com.hgl.recruitms.controller;

import java.io.IOException;
import java.util.HashMap;
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
import com.hgl.recruitms.common.web.restful.response.CommonResponseBuilder;
import com.hgl.recruitms.common.web.restful.response.ResponseObject;
import com.hgl.recruitms.enums.TBHeaderEnum;
import com.hgl.recruitms.model.Department;
import com.hgl.recruitms.model.QAInfo;
import com.hgl.recruitms.model.RecruitInfo;
import com.hgl.recruitms.model.Score;
import com.hgl.recruitms.service.DepartmentService;
import com.hgl.recruitms.service.DictionaryService;
import com.hgl.recruitms.service.QAInfoService;
import com.hgl.recruitms.service.RecruitInfoService;
import com.hgl.recruitms.service.StudentScoreService;

/**
 * ClassName: QAInfoController <br/>
 * Description：答疑信息控制层接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@RestController
@RequestMapping("/student")
public class QAInfoController {
	static Logger logger = LoggerFactory.getLogger(QAInfoController.class);
	@Autowired
	private CommonResponseBuilder builder;

	@Autowired
	private QAInfoService qaInfoService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private RecruitInfoService recruitInfoService;

	@Autowired
	private StudentScoreService studentScoreService;
	
	@Autowired
	private DictionaryService dictionaryService;

	/**
	 * listPageQAInfo:列出比较热门的问题. <br/>
	 * 
	 * @author huanggl
	 * @param response
	 * @param request
	 * @param pageIndex
	 * @param pageSize
	 * @param sQuestion
	 * @return
	 */
	@RequestMapping(value = "/listQAInfos", method = { RequestMethod.GET })
	public ModelAndView listPageQAInfo(HttpServletResponse response, HttpServletRequest request,
			@RequestParam Integer pageIndex, @RequestParam Integer pageSize, String sQuestion) {
		if (pageIndex == null || pageSize == null) {
			return new ModelAndView("errorPage.jsp");
		}
		request.getSession().setAttribute("listQAInfos", null);
		PageInfo<QAInfo> pageInfo = qaInfoService.listQAInfos(pageIndex, pageSize, sQuestion);
		request.getSession().setAttribute("listQAInfos", pageInfo);
		return new ModelAndView("QAInfoList.jsp");
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

	@RequestMapping(value = "/qaInfo", method = { RequestMethod.PUT })
	public ResponseObject<?> updateQAInfo(@RequestBody QAInfo qaInfo) {
		logger.debug("更新内容为：{}" + qaInfo.toString());
		boolean flag = qaInfoService.updateQAInfo(qaInfo);
		if (!flag) {
			return builder.error(-1, "更改出错！");
		}
		return builder.success(qaInfo);
	}

	@RequestMapping(value = "/listDepartments", method = { RequestMethod.GET })
	public ModelAndView listPageDepartment(HttpServletResponse response, HttpServletRequest request,
			@RequestParam Integer pageIndex, @RequestParam Integer pageSize, String sDeptCode, String sShortName,
			String sFullName, String sRegion, String dbEnrolScore) {
		if (pageIndex == null || pageSize == null) {
			return new ModelAndView("errorPage.jsp");
		}
		PageInfo<Department> pageInfo = departmentService.listDepartments(pageIndex, pageSize, sDeptCode, sShortName,
				sFullName, sRegion, dbEnrolScore);
		request.getSession().setAttribute("departmentListDic", pageInfo);
		return new ModelAndView("enrollmentPlan.jsp");
	}

	@RequestMapping(value = "/getIndexInfo", method = { RequestMethod.GET })
	public ResponseObject<Object> getIndexInfo(HttpServletResponse response, HttpServletRequest request,
			@RequestParam String sStudentName) {

		Score score = studentScoreService.getScoreByName(sStudentName);
		RecruitInfo recruitInfo = recruitInfoService.getRecruitInfo(sStudentName);
		
		Department department = departmentService.getDeptByCode(recruitInfo.getsAdmitedMajor());
		String sAdmitedMajor = department.getsFullName();
		String deptName = dictionaryService.getDicByItemCodeAndKey("COLLEGE",department.getsRegion()).getsItemValue();
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (score == null || recruitInfo == null) {
			return builder.error(-1, "初始化失败！");
		}
		map.put("score", score);
		map.put("sAdmitedMajor", sAdmitedMajor);
		map.put("deptName", deptName);
		map.put("recruitInfo", recruitInfo);
		return builder.success(map);
	}

	/**
	 * deptInfoList:导出招生计划表. <br/>
	 * 
	 * @author huanggl
	 * @param request
	 * @param response
	 * @param sDeptCode
	 * @param sShortName
	 * @param sFullName
	 * @param sRegion
	 * @param dbEnrolScore
	 * @param nDeptNoList
	 * @throws IOException
	 */
	@RequestMapping(value = "/export/deptInfoList", method = { RequestMethod.GET })
	public void deptInfoList(HttpServletRequest request, HttpServletResponse response, @RequestParam String sDeptCode,
			@RequestParam String sShortName, @RequestParam String sFullName, @RequestParam String sRegion,
			@RequestParam String dbEnrolScore, @RequestParam List<Integer> nDeptNoList) throws IOException {
		String exportType = TBHeaderEnum.DEPTINFO.getName();
		sDeptCode = StringUtils.hasText(sDeptCode) ? sDeptCode.trim() : "";
		sShortName = StringUtils.hasText(sShortName) ? sShortName.trim() : "";
		sFullName = StringUtils.hasText(sFullName) ? sFullName.trim() : "";
		sRegion = StringUtils.hasText(sRegion) ? sRegion.trim() : "";
		// 根据条件获取成绩列表
		List<List<String>> table = departmentService.exportRecruitInfo(sDeptCode.trim(), sShortName.trim(),
				sFullName.trim(), sRegion.trim(), dbEnrolScore.trim(), nDeptNoList, exportType);
		String fileName = "招生计划-";
		// 设置列宽度
		int[] sheetWidth = { 5000, 5000, 5000, 5000, 5000, 5000, 4000 };
		ExportUtil.export(table, fileName, response, sheetWidth);// 根据查询得到的列表生成excel

		logger.info("导出完成！{},{},{},{},{},{}", sDeptCode, sShortName, sFullName, sRegion, nDeptNoList);
	}

}
