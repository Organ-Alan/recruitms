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
import com.hgl.recruitms.model.Score;
import com.hgl.recruitms.service.StudentScoreService;

/**
 * ClassName: ScoreInfoController <br/>
 * Description：学生成绩信息控制层接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@RestController
@RequestMapping("/admin")
public class ScoreInfoController {
	static Logger logger = LoggerFactory.getLogger(ScoreInfoController.class);
	@Autowired
	private CommonResponseBuilder builder;

	@Autowired
	private StudentScoreService scoreInfoService;

	/**
	 * listPageScoreInfo:分页获取成绩信息. <br/>
	 * 
	 * @author huanggl
	 * @param pageIndex
	 * @param pageSize
	 * @param sStudentNo
	 * @param sStudentName
	 * @param sSubjectType
	 * @param dbScore
	 * @param dbChinses
	 * @param dbEnglish
	 * @param dbMath
	 * @param sTotalScore
	 * @return
	 */
	@RequestMapping(value = "/listScoreInfos", method = { RequestMethod.GET })
	public ModelAndView listPageScoreInfo(HttpServletResponse response,HttpServletRequest request,@RequestParam Integer pageIndex, @RequestParam Integer pageSize,
			String sStudentNo, String sStudentName, String sSubjectType, String sTotalScore) {
		if (pageIndex == null || pageSize == null) {
			return new ModelAndView("errorPage.jsp");
		}
		request.getSession().setAttribute("listScoreInfos", null);
		PageInfo<Score> pageInfo = scoreInfoService.listScores(pageIndex, pageSize, sStudentNo, sStudentName,
				sSubjectType, sTotalScore);
		request.getSession().setAttribute("listScoreInfos", pageInfo);
		logger.debug(JsonUtil.serialize(pageInfo));
		return new ModelAndView("studentScoreList.jsp");
	}

	/**
	 * getScoreInfoById:根据学生成绩信息编码获取学生成绩信息. <br/>
	 * 
	 * @author huanggl
	 * @param nStudentId
	 * @return
	 */
	@RequestMapping(value = "/scoreInfo/{nStudentId}", method = { RequestMethod.GET })
	public ResponseObject<?> getScoreInfoBynQaId(@PathVariable Integer nStudentId) {
		if (nStudentId == null) {
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "学生成绩信息内部编码" + nStudentId + "错误！");
		}
		return builder.success(scoreInfoService.getScore(nStudentId));
	}

	/**
	 * insertScoreInfo:新增学生成绩信息. <br/>
	 * 
	 * @author huanggl
	 * @param scoreInfo
	 * @return
	 */
	@RequestMapping(value = "/scoreInfo", method = { RequestMethod.POST })
	public ResponseObject<?> insertScoreInfo(@RequestBody Score scoreInfo) {
		logger.info("需要新增学生成绩信息：{}", scoreInfo);
		if (scoreInfo == null) {// 新增信息为空
			return builder.error(ErrorEnum.IllegalArgument.getErrorCode(), "请求对象出错（" + scoreInfo + "）");
		}
		boolean isSuccess = scoreInfoService.insertScore(scoreInfo);
		if (isSuccess) {
			return builder.success(scoreInfo);
		} else {
			return builder.error(ErrorEnum.NullPointer.getErrorCode(), "无法添加学生成绩信息（" + scoreInfo + "）,请重新尝试！");
		}
	}

	/**
	 * updateScoreInfo:修改学生成绩信息 <br/>
	 * 
	 * @author huanggl
	 * @param scoreInfo
	 * @return
	 */
	@RequestMapping(value = "updateScoreInfo", method = { RequestMethod.POST })
	public ResponseObject<?> updateScoreInfo(@RequestBody Score scoreInfo) {
		logger.debug("更新内容为：{}" + scoreInfo.toString());
		boolean flag = scoreInfoService.updateScore(scoreInfo);
		if (!flag) {
			return builder.error(-1, "更改出错！");
		}
		return builder.success(scoreInfo);
	}
	
	/**
	 * updateScoreInfo:删除学生成绩信息 <br/>
	 * 
	 * @author huanggl
	 * @param scoreInfo
	 * @return
	 */
	@RequestMapping(value = "delScoreInfo", method = { RequestMethod.POST })
	public ResponseObject<?> delScoreInfo(@RequestParam Integer nStudentId) {
		logger.debug("删除内容为：{}" + nStudentId);
		boolean flag = scoreInfoService.delScore(nStudentId);
		if (!flag) {
			return builder.error(-1, "删除出错！");
		}
		return builder.success();
	}

	@RequestMapping(value = "/export/scoreInfoList", method = { RequestMethod.GET })
	public void exportScoreInfoList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String sStudentNo, @RequestParam String sStudentName, @RequestParam String sSubjectType,
			@RequestParam String sTotalScore, @RequestParam List<Integer> nStudentIdList) throws IOException {
		String exportType = TBHeaderEnum.SCOREINFO.getName();
		// 根据条件获取成绩列表
		List<List<String>> table = scoreInfoService.exportScoreInfo(sStudentNo.trim(), sStudentName.trim(),
				sSubjectType.trim(), sTotalScore.trim(), nStudentIdList, exportType);

		sStudentNo = StringUtils.hasText(sStudentNo) ? sStudentNo.trim() : "";
		sStudentName = StringUtils.hasText(sStudentName) ? sStudentName.trim() : "";
		String fileName = "新生成绩信息列表-";
		// 设置列宽度
		int[] sheetWidth = { 5000, 5000, 5000, 5000, 5000, 5000, 4000 };
		ExportUtil.export(table, fileName, response, sheetWidth);// 根据查询得到的列表生成excel

		logger.info("导出完成！{},{},{},{},{},{},{},{},{}", sStudentNo, sStudentName, sSubjectType, sTotalScore,
				nStudentIdList);
	}
}
