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

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.common.controller.response.ErrorEnum;
import com.hgl.recruitms.common.util.ExportUtil;
import com.hgl.recruitms.common.web.restful.response.CommonResponseBuilder;
import com.hgl.recruitms.common.web.restful.response.ResponseObject;
import com.hgl.recruitms.enums.TBHeaderEnum;
import com.hgl.recruitms.model.StudentInfo;
import com.hgl.recruitms.service.StudentInfoService;

/**
 * ClassName: StudentInfoController <br/>
 * Description：考生信息控制层接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@RestController
@RequestMapping("/{version}/student")
public class StudentInfoController {
	static Logger logger = LoggerFactory.getLogger(StudentInfoController.class);
	@Autowired
	private CommonResponseBuilder builder;

	@Autowired
	private StudentInfoService studentInfoService;

	@RequestMapping(value = "/listStudentInfos", method = { RequestMethod.GET })
	public ResponseObject<?> listPageStudentInfo(@RequestParam Integer pageIndex, @RequestParam Integer pageSize,
			String sCandidateNum, String sStudentName, String sNativePlace, String sEnrolMajor, String sDataFlag) {
		if (pageIndex == null || pageSize == null) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "参数" + pageIndex + "、" + pageSize + "错误！");
		}
		PageInfo<StudentInfo> pageInfo = studentInfoService.listStudentInfos(pageIndex, pageSize, sCandidateNum,
				sStudentName, sNativePlace, sEnrolMajor, sDataFlag);
		return builder.success(pageInfo);
	}

	/**
	 * getStudentInfoById:根据考生信息编码获取考生信息. <br/>
	 * 
	 * @author huanggl
	 * @param nStudentId
	 * @return
	 */
	@RequestMapping(value = "/studentInfo/{nStudentId}", method = { RequestMethod.GET })
	public ResponseObject<?> getStudentInfoBynQaId(@PathVariable Integer nStudentId) {
		if (nStudentId == null) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "考生信息内部编码" + nStudentId + "错误！");
		}
		return builder.success(studentInfoService.getStudentInfo(nStudentId));
	}

	/**
	 * insertStudentInfo:新增考生信息. <br/>
	 * 
	 * @author huanggl
	 * @param studentInfo
	 * @return
	 */
	@RequestMapping(value = "/studentInfo", method = { RequestMethod.POST })
	public ResponseObject<?> insertStudentInfo(@RequestBody StudentInfo studentInfo) {
		logger.info("需要新增考生信息：{}", studentInfo);
		if (studentInfo == null) {// 新增信息为空
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "请求对象出错（" + studentInfo + "）");
		}
		boolean isSuccess = studentInfoService.insertStudentInfo(studentInfo);
		if (isSuccess) {
			return builder.success(studentInfo);
		} else {
			return builder.error(ErrorEnum.NullPointer.getErrorCode(), "无法添加考生信息（" + studentInfo + "）,请重新尝试！");
		}
	}

	/**
	 * updateStudentInfo:修改考生信息 <br/>
	 * 
	 * @author huanggl
	 * @param studentInfo
	 * @return
	 */
	@RequestMapping(value = "studentInfo", method = { RequestMethod.PUT })
	public ResponseObject<?> updateStudentInfo(@RequestBody StudentInfo studentInfo) {
		logger.debug("更新内容为：{}" + studentInfo.toString());
		boolean flag = studentInfoService.updateStudentInfo(studentInfo);
		if (!flag) {
			return builder.error(-1, "更改出错！");
		}
		return builder.success(studentInfo);
	}

	/**
	 * countInfo:统计学生信息记录数. <br/>
	 * 
	 * @author huanggl
	 * @return
	 */
	@RequestMapping(value = "countInfo", method = { RequestMethod.GET })
	public ResponseObject<?> countInfo() {
		int count = studentInfoService.accountStudent();
		return builder.success(count);
	}

	@RequestMapping(value = "/export/studentInfoList", method = { RequestMethod.GET })
	public void exportStudentInfoList(HttpServletRequest request, HttpServletResponse response, String sCandidateNum,
			@RequestParam String sStudentName,@RequestParam String sNativePlace,@RequestParam String sEnrolMajor,@RequestParam String sDataFlag,
			@RequestParam List<Integer> nStudentIdList) throws IOException {
		String exportType = TBHeaderEnum.STUDENTINFO.getName();
		// 根据条件获取新生列表
		List<List<String>> table = studentInfoService.exportRecruitInfo(sCandidateNum, sStudentName, sNativePlace,
				sEnrolMajor, sDataFlag, nStudentIdList, exportType);

		sCandidateNum = StringUtils.hasText(sCandidateNum) ? sCandidateNum.trim() : "";
		sStudentName = StringUtils.hasText(sStudentName) ? sStudentName.trim() : "";
		String fileName = "考生信息列表-";
		// 设置列宽度
		int[] sheetWidth = { 5000, 5000, 5000, 5000, 5000, 5000, 4000 };
		ExportUtil.export(table, fileName, response, sheetWidth);// 根据查询得到的列表生成excel

		logger.info("导出完成！{},{},{},{},{}{},{}", sCandidateNum, sStudentName, sNativePlace, sEnrolMajor, sDataFlag,
				nStudentIdList);
	}
}
