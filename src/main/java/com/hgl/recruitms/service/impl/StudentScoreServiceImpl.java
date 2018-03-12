package com.hgl.recruitms.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.dao.ScoreMapper;
import com.hgl.recruitms.enums.StudentScoreColEnum;
import com.hgl.recruitms.enums.TBHeaderEnum;
import com.hgl.recruitms.model.Score;
import com.hgl.recruitms.model.ScoreExample;
import com.hgl.recruitms.model.ScoreExample.Criteria;
import com.hgl.recruitms.service.DictionaryService;
import com.hgl.recruitms.service.StudentScoreService;

/**
 * ClassName: StudentScoreServiceImpl <br/>
 * Description：成绩信息业务接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@Service
public class StudentScoreServiceImpl implements StudentScoreService {
	static Logger logger = LoggerFactory.getLogger(StudentScoreServiceImpl.class);
	@Autowired
	private ScoreMapper scoreMapper;

	@Autowired
	private DictionaryService dictionaryService;

	@Override
	public boolean insertScore(Score studentScore) {
		// 总分等于综合科+语文+数学+英语
		Double result = studentScore.getDbScore() + studentScore.getDbChinses() + studentScore.getDbEnglish()
				+ studentScore.getDbMath();
		studentScore.setsTotalScore(String.valueOf(result));
		logger.debug(String.valueOf(result));
		int count = scoreMapper.insert(studentScore);
		logger.info("新增成绩信息:" + studentScore.toString() + "，结果：" + (count > 0));
		return count > 0;
	}

	@Override
	public boolean delScore(Integer nStudentId) {
		int count = scoreMapper.deleteByPrimaryKey(nStudentId);
		if (count !=1) {
			throw new RuntimeException("删除基础信息失败，抛出异常，事务回滚");
		}
		logger.info("删除成绩信息:" + count + "，结果：" + (count > 0));
		return count > 0;
	}
	
	@Override
	public Score getScore(Integer nStudentId) {
		Score studentScore = new Score();
		ScoreExample studentScoreExample = new ScoreExample();
		// 拼装条件（内部编码）
		studentScoreExample.createCriteria().andNStudentIdEqualTo(nStudentId);
		List<Score> studentScoreList = scoreMapper.selectByExample(studentScoreExample);
		if (studentScoreList != null && studentScoreList.size() > 0) {
			studentScore = studentScoreList.get(0);// 获取成绩信息信息
		}
		return studentScore;
	}

	@Override
	public boolean updateScore(Score studentScore) {
		// 通过主键成绩信息编码进行修改
		// 总分等于综合科+语文+数学+英语
		Double result = studentScore.getDbScore() + studentScore.getDbChinses() + studentScore.getDbEnglish()
				+ studentScore.getDbMath();
		studentScore.setsTotalScore(String.valueOf(result));
		logger.debug(String.valueOf(result));
		int count = scoreMapper.updateByPrimaryKeySelective(studentScore);
		// 当修改成绩信息信息失败时
		if (count < 1) {
			logger.error("修改基础信息失败,修改基础信息数据为：" + studentScore.toString() + "，条件为:" + studentScore.getnStudentId());
			throw new RuntimeException("修改基础信息失败，抛出异常，事务回滚");
		}
		return count > 0;
	}

	/**
	 * listStudentScore:分页获取成绩信息 <br/>
	 * 
	 * @see com.hgl.recruitms.service.StudentScoreService#listStudentScore(java.lang.Integer,
	 *      java.lang.Integer, java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public PageInfo<Score> listScores(Integer pageIndex, Integer pageSize, String sStudentNo, String sStudentName,
			String sSubjectType) {
		// 用于查询全部信息，判断是否需要查询全部的信息，包括已变更，已删除的产品信息
		logger.info("查询成绩信息列表：{},{},{},{},{},{},{},{}", pageIndex, pageSize, sStudentNo, sStudentName, sSubjectType);
		// 拼装条件
		ScoreExample example = new ScoreExample();
		Criteria criteria = example.createCriteria();
		criteria.andNStudentIdIsNotNull();
		// 模糊查询
		if (StringUtils.hasText(sStudentNo)) {
			criteria.andSStudentNoLike("%" + sStudentNo + "%");
		}
		if (StringUtils.hasText(sStudentName)) {
			criteria.andSStudentNameLike("%" + sStudentName + "%");
		}
		if (StringUtils.hasText(sSubjectType)) {
			criteria.andSSubjectTypeLike("%" + sSubjectType + "%");
		}
		example.setOrderByClause(" S_TOTAL_SCORE,DB_SCORE,DB_CHINSES,DB_ENGLISH,DB_MATH ASC ");
		logger.debug("成绩信息列表当前显示第" + pageIndex + "页且当前页面展示的条数" + pageSize);
		// 调用静态方法，设置分页参数即可，随后的第一次查询的sql语句会自动被分页插件改装成带有分页查询的sql语句
		PageHelper.startPage(pageIndex, pageSize);
		// 获取满足条件的数据
		List<Score> studentScores = scoreMapper.selectByExample(example);
		return new PageInfo<Score>(studentScores);
	}

	@Override
	public List<List<String>> exportScoreInfo(String sStudentNo, String sStudentName, String sSubjectType,
			String sTotalScore, List<Integer> nStudentIdList, String exportType) {
		List<List<String>> table = new ArrayList<>();
		List<String> line = new ArrayList<>();
		// 第一行，表头：根据枚举配置表头信息
		String headsStr = TBHeaderEnum.fromName(exportType).getCode();
		String[] headArr = headsStr.split(",");
		for (String head : headArr) {

			// 通过属性获取对应的中文名称
			String name = StudentScoreColEnum.fromCode(head).getName();
			line.add(name);
		}
		table.add(line);

		PageInfo<Score> pageInfo = listScores(0, 0, sStudentNo.trim(), sStudentName.trim(), sSubjectType.trim());
		List<Score> list = pageInfo.getList();
		if (list != null && list.size() > 0) {
			for (Score studentScore : list) {
				line = new ArrayList<>();
				for (String head : headArr) {
					String sValue = "";
					Field field = null;
					try {
						// 在父类中没有获取到属性则去子类中取值，子类中依旧无法找到属性时，抛出异常
						try {
							field = Score.class.getDeclaredField(head);
						} catch (NoSuchFieldException e) {
							field = Score.class.getDeclaredField(head);
						}
						// 设置为可访问recruitInfo内部属性
						field.setAccessible(true);
						try {
							// 处理特殊字段数据：枚举、时间、成绩
							if ((head.equals("dbScore")) || (head.equals("dbChinses")) || (head.equals("dbEnglish"))
									|| (head.equals("dbMath"))) {
								// 如果是成绩，转换为Double类型
								Double temp = (Double) field.get(studentScore);
								sValue = String.valueOf(temp);
							} else if (head.equals("sSubjectType")) {
								// 如果是政治面貌，调用字典接口查询。wk-文科类，lk-理科类，ms-美术类
								sValue = (String) field.get(studentScore);
								if (StringUtils.hasText(sValue)) {
									sValue = dictionaryService.getDicByItemCodeAndKey("SUBJECT_TYPE", sValue)
											.getsItemValue();
								}
							} else {
								sValue = (String) field.get(studentScore);
							}
						} catch (IllegalArgumentException e) {
							logger.error("成绩信息导出出现异常（IllegalArgumentException）：：" + e);
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							logger.error("成绩信息导出出现异常(IllegalAccessException):" + e);
							e.printStackTrace();
						}
					} catch (NoSuchFieldException e) {
						logger.error("成绩信息导出出现异常(NoSuchFieldException):" + e);
						e.printStackTrace();
					} catch (SecurityException e) {
						logger.error("成绩信息导出出现异常(SecurityException):" + e);
						e.printStackTrace();
					}
					line.add(sValue);
				}
				table.add(line);
			}
		}
		return table;
	}

	/**  
	 * 通过名字获取成绩
	 * @see com.hgl.recruitms.service.StudentScoreService#getScoreByName(java.lang.String)  
	 */
	@Override
	public Score getScoreByName(String sStudentName) {
		ScoreExample example = new ScoreExample();
		Criteria criteria = example.createCriteria();
		criteria.andNStudentIdIsNotNull().andSStudentNameEqualTo(sStudentName);
		List<Score> scores = scoreMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(scores)) {
			throw new RuntimeException("无法获取成绩，请联系管理员！");
		}
		return scores.get(0);
	}

}
