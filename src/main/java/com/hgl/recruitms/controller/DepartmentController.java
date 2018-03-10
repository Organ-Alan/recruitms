package com.hgl.recruitms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
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
import com.hgl.recruitms.common.bean.EnrolmentInfo;
import com.hgl.recruitms.common.controller.response.ErrorEnum;
import com.hgl.recruitms.common.util.ExportUtil;
import com.hgl.recruitms.common.util.JsonUtil;
import com.hgl.recruitms.common.web.restful.response.CommonResponseBuilder;
import com.hgl.recruitms.common.web.restful.response.ResponseObject;
import com.hgl.recruitms.enums.TBHeaderEnum;
import com.hgl.recruitms.model.Department;
import com.hgl.recruitms.service.DepartmentService;

/**
 * ClassName: DepartmentController <br/>
 * Description：院系部门控制层接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@RestController
@RequestMapping("/admin")
public class DepartmentController {
	static Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	private CommonResponseBuilder builder;
	
	@Autowired
	private DepartmentService departmentService;

	/**
	 * listPageDepartment:分页查询院系专业信息. <br/>
	 * 
	 * @author huanggl
	 * @param pageIndex
	 * @param pageSize
	 * @param sDeptCode
	 * @param sShortName
	 * @param sFullName
	 * @param sRegion
	 * @param dbEnrolScore
	 * @return
	 */
	@RequestMapping(value = "/listDepartments", method = { RequestMethod.GET })
	public ModelAndView listPageDepartment(HttpServletResponse response,HttpServletRequest request,@RequestParam Integer pageIndex, @RequestParam Integer pageSize,
			String sDeptCode, String sShortName, String sFullName, String sRegion, String dbEnrolScore) {
		if (pageIndex == null || pageSize == null) {
			return new ModelAndView("errorPage.jsp");
		}
		PageInfo<Department> pageInfo = departmentService.listDepartments(pageIndex, pageSize, sDeptCode, sShortName,
				sFullName, sRegion, dbEnrolScore);
		request.getSession().setAttribute("departmentListDic", pageInfo);
		return new ModelAndView("enrollmentPlan.jsp");
	}

	/**
	 * getDeptBynDeptNo:根据院系专业编码获取院系专业信息. <br/>
	 * 
	 * @author huanggl
	 * @param nDeptNo
	 * @return
	 */
	@RequestMapping(value = "/department/{nDeptNo}", method = { RequestMethod.GET })
	public ResponseObject<?> getDeptBynDeptNo(@PathVariable Integer nDeptNo) {
		if (nDeptNo == null) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "院系专业内部" + nDeptNo + "错误！");
		}
		return builder.success(departmentService.getDepartment(nDeptNo));
	}

	/**
	 * insertDictInfo:新增院系专业信息. <br/>
	 * 
	 * @author huanggl
	 * @param department
	 * @return
	 */
	@RequestMapping(value = "/department", method = { RequestMethod.POST })
	public ModelAndView insertDictInfo(@RequestBody Department department) {
		logger.info("需要新增的院系专业信息：{}", department);
		if (department == null) {// 新增信息为空
			return new ModelAndView("errorPage.jsp");
		}
		boolean isSeccess = departmentService.insertDepartment(department);
		if (isSeccess) {
			return new ModelAndView("enrollmentPlan.jsp");
		} else {
			return new ModelAndView("errorPage.jsp");
		}
	}

	/**
	 * delDictInfo:根据nDeptNo删除院系专业信息. <br/>
	 * 
	 * @author huanggl
	 * @param nDeptNo
	 * @return
	 */
	@RequestMapping(value = "/delDepartment/{nDeptNo}", method = { RequestMethod.POST })
	public ResponseObject<?> delDictInfo(@PathVariable Integer nDeptNo) {
		logger.info("需要更新的院系专业信息：{}", nDeptNo);
		boolean isSuccess = departmentService.delDeptInfo(nDeptNo);
		if (isSuccess) {
			return builder.success(isSuccess);
		} else {
			return builder.error(-1, "删除院系专业信息失败，请重新尝试！");
		}
	}

	/**
	 * updateDepartment:修改院系专业信息. <br/>
	 * 
	 * @author huanggl
	 * @param department
	 *            修改对象
	 * @param sUsername
	 * @return
	 */
	@RequestMapping(value = "/deptInfo", method = { RequestMethod.POST })
	public ResponseObject<Object> updateDepartment(@RequestBody Department department, @RequestParam String sUsername) {
		logger.debug("院系专业更新的数据为：" + (department == null ? null : department.toString()));
		if (department == null) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "参数为空");
		}
		// 非空校验
		if (!StringUtils.hasText(department.getsDeptCode()) || !StringUtils.hasText(department.getsFullName())) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "专业代码或专业简称不能为空");
		}
		boolean flag = departmentService.updateDepartment(department, sUsername);
		if (flag) {
			return builder.success(department);
		}
		return builder.error(-1, "录入到修改审核列表失败");

	}

	/**
	 * updateRevisionReview:(审核通过或者审核不通过). <br/>
	 * 
	 * @author huanggl
	 * @param revisionReview
	 *            新生内部编码数组 、修改审核id数组和业务类型（与前端商量规定的类型）
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/auditStatus", method = { RequestMethod.POST })
	public ResponseObject<Object> updateRevisionReview(@RequestParam List<Integer> nDeptNoList,
			@RequestParam List<Integer> sAuditNoList, @RequestParam String auditStatus, String sUsername)
			throws IllegalArgumentException, IllegalAccessException, ParseException {
		System.out.println(123);
		logger.debug("院系专业审核通过或者不通过的数据为：{}{}{}" + nDeptNoList + sAuditNoList + auditStatus);
		if (CollectionUtils.isEmpty(sAuditNoList) || CollectionUtils.isEmpty(nDeptNoList)
				|| !StringUtils.hasText(auditStatus)) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "参数为空");
		}
		
		boolean flag = departmentService.updateRevisionReview(nDeptNoList, sAuditNoList, auditStatus, sUsername);
		if (flag) {
			return builder.success(flag);
		}
		return builder.error(-1, "调用修改审核接口失败");
	}

	@RequestMapping(value = "/getIndexInfo", method = { RequestMethod.GET })
	public ResponseObject<Object> getIndexInfo(HttpServletResponse response,HttpServletRequest request){
		EnrolmentInfo enrolmentInfo = departmentService.getEnrolmentInfo();
		if (enrolmentInfo == null) {
			return builder.error(-1,"初始化失败！");
		}
		request.getSession().setAttribute("enrolmentInfo", enrolmentInfo);
		System.out.println(JsonUtil.serialize(enrolmentInfo));
		return builder.success(enrolmentInfo);
	}
	
	/**  
	 * deptInfoList:导出招生计划表. <br/>  
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
	public void deptInfoList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String sDeptCode,@RequestParam String sShortName,@RequestParam String sFullName,@RequestParam String sRegion,
			@RequestParam String dbEnrolScore,@RequestParam List<Integer> nDeptNoList) throws IOException {
		String exportType = TBHeaderEnum.DEPTINFO.getName();
		sDeptCode = StringUtils.hasText(sDeptCode) ? sDeptCode.trim() : "";
		sShortName = StringUtils.hasText(sShortName) ? sShortName.trim() : "";
		sFullName = StringUtils.hasText(sFullName) ? sFullName.trim() : "";
		sRegion = StringUtils.hasText(sRegion) ? sRegion.trim() : "";
		// 根据条件获取成绩列表
		List<List<String>> table = departmentService.exportRecruitInfo(sDeptCode.trim(), sShortName.trim(), sFullName.trim(), sRegion.trim(), dbEnrolScore.trim(), nDeptNoList, exportType);
		String fileName = "招生计划-";
		// 设置列宽度
		int[] sheetWidth = { 5000, 5000, 5000, 5000, 5000, 5000, 4000 };
		ExportUtil.export(table, fileName, response, sheetWidth);// 根据查询得到的列表生成excel

		logger.info("导出完成！{},{},{},{},{},{}", sDeptCode, sShortName, sFullName, sRegion,
				nDeptNoList);
	}
}
