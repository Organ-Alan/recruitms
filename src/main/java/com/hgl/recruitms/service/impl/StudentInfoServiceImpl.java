package com.hgl.recruitms.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.dao.StudentInfoMapper;
import com.hgl.recruitms.enums.DataStatusEnum;
import com.hgl.recruitms.enums.StudentInfoColEnum;
import com.hgl.recruitms.enums.TBHeaderEnum;
import com.hgl.recruitms.model.StudentInfo;
import com.hgl.recruitms.model.StudentInfoExample;
import com.hgl.recruitms.model.StudentInfoExample.Criteria;
import com.hgl.recruitms.service.DepartmentService;
import com.hgl.recruitms.service.DictionaryService;
import com.hgl.recruitms.service.StudentInfoService;

/**
 * ClassName: StudentInfoServiceImpl <br/>
 * Description：考生信息业务接口
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
@Service
public class StudentInfoServiceImpl implements StudentInfoService {
	static Logger logger = LoggerFactory.getLogger(StudentInfoServiceImpl.class);
	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private DictionaryService dictionaryService;

	@Override
	public boolean insertStudentInfo(StudentInfo studentInfo) {
		int count = studentInfoMapper.insert(studentInfo);
		logger.info("新增新生信息:" + studentInfo.toString() + "，结果：" + (count > 0));
		return count > 0;
	}

	@Override
	public StudentInfo getStudentInfo(Integer nStudentId) {
		StudentInfo studentInfo = new StudentInfo();
		StudentInfoExample studentInfoExample = new StudentInfoExample();
		// 拼装条件（产品内部编码）
		studentInfoExample.createCriteria().andNStudentIdEqualTo(nStudentId);
		List<StudentInfo> studentInfoList = studentInfoMapper.selectByExample(studentInfoExample);
		if (studentInfoList != null && studentInfoList.size() > 0) {
			studentInfo = studentInfoList.get(0);// 获取学生信息信息
		}
		return studentInfo;
	}

	@Override
	public boolean updateStudentInfo(StudentInfo studentInfo) {
		// 通过主键学生信息编码进行修改
		int count = studentInfoMapper.updateByPrimaryKey(studentInfo);
		logger.debug("调用数据库修改学生信息信息的条数为::" + count);
		// 当修改学生信息信息失败时
		if (count < 1) {
			logger.error("修改基础信息失败,修改基础信息数据为：" + studentInfo.toString() + "，条件为:" + studentInfo.getnStudentId());
			throw new RuntimeException("修改基础信息失败，抛出异常，事务回滚");
		}
		return count > 0;
	}

	/**
	 * listStudentInfo:分页获取新生信息 <br/>
	 * 
	 * @see com.hgl.recruitms.service.StudentInfoService#listStudentInfo(java.lang.Integer,
	 *      java.lang.Integer, java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public PageInfo<StudentInfo> listStudentInfos(Integer pageIndex, Integer pageSize, String sCandidateNum,
			String sStudentName, String sNativePlace, String sEnrolMajor, String sDataFlag) {
		// 用于查询全部信息，判断是否需要查询全部的信息，包括已变更，已删除的产品信息
		logger.info("查询考生信息列表：{},{},{},{},{},{},{},{}", pageIndex, pageSize, sCandidateNum, sStudentName, sNativePlace,
				sEnrolMajor, sDataFlag);
		// 拼装条件
		StudentInfoExample example = new StudentInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andNStudentIdIsNotNull();
		// 模糊查询
		if (StringUtils.hasText(sCandidateNum)) {
			criteria.andSCandidateNumLike("%" + sCandidateNum + "%");
		}
		if (StringUtils.hasText(sStudentName)) {
			criteria.andSStudentNameLike("%" + sStudentName + "%");
		}
		if (StringUtils.hasText(sNativePlace)) {
			criteria.andSNativePlaceLike("%" + sNativePlace + "%");
		}
		if (StringUtils.hasText(sEnrolMajor)) {
			criteria.andSEnrolMajorLike("%" + sEnrolMajor + "%");
		}
		if (StringUtils.hasText(sDataFlag)) {
			criteria.andSDataFlagEqualTo(sDataFlag);
		}
		example.setOrderByClause(" S_CANDIDATE_NUM ASC ");
		logger.debug("考生信息列表当前显示第" + pageIndex + "页且当前页面展示的条数" + pageSize);
		// 调用静态方法，设置分页参数即可，随后的第一次查询的sql语句会自动被分页插件改装成带有分页查询的sql语句
		PageHelper.startPage(pageIndex, pageSize);
		// 获取满足条件的数据
		List<StudentInfo> studentInfos = studentInfoMapper.selectByExample(example);
		return new PageInfo<StudentInfo>(studentInfos);
	}

	/**
	 * 考生信息可以删除，但是只能进行软删除，一遍后续管理人员追踪数据.
	 * 
	 * @see com.hgl.recruitms.service.StudentInfoService#delOneToManyBasic(java.lang.Integer[])
	 */
	@Override
	public boolean deleteStudentInfo(Integer[] nStudentIds) throws IndexOutOfBoundsException {
		StudentInfoExample updateExample = new StudentInfoExample();
		StudentInfoExample.Criteria updateCriteria = updateExample.createCriteria();
		List<Integer> listnStudentIds = Arrays.asList(nStudentIds);
		if (CollectionUtils.isEmpty(listnStudentIds)) {
			return false;
		}
		updateCriteria.andNStudentIdIn(listnStudentIds);
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setsDataFlag(DataStatusEnum.INVALID.getCode());
		int count = studentInfoMapper.updateByExampleSelective(studentInfo, updateExample);
		if (nStudentIds.length != count) {
			// 当批量删除数量，与受影响行数不符时，抛出异常，事务回滚
			logger.info("批量删除失败,删除数量与需要删除数量不符：" + listnStudentIds);
			throw new IndexOutOfBoundsException("批量删除失败");
		}
		logger.debug("批量删除：" + listnStudentIds.toString() + "考生信息，结果：" + (count > 0));
		return count > 0;
	}

	/**
	 * 统计学生数目
	 * 
	 * @see com.hgl.recruitms.service.StudentInfoService#accountStudent()
	 */
	@Override
	public int accountStudent() {
		StudentInfoExample example = new StudentInfoExample();
		// 过滤无效的学生信息
		example.createCriteria().andSDataFlagEqualTo(DataStatusEnum.INVALID.getCode());
		int count = (int) studentInfoMapper.countByExample(example);
		return count;
	}

	@Override
	public List<List<String>> exportRecruitInfo(String sCandidateNum, String sStudentName, String sNativePlace,
			String sEnrolMajor, String sDataFlag, List<Integer> nStudentIdList, String exportType) {
		List<List<String>> table = new ArrayList<>();
		List<String> line = new ArrayList<>();
		// 第一行，表头：根据枚举配置表头信息
		String headsStr = TBHeaderEnum.fromName(exportType).getCode();
		String[] headArr = headsStr.split(",");
		for (String head : headArr) {

			// 通过属性获取对应的中文名称
			String name = StudentInfoColEnum.fromCode(head).getName();
			line.add(name);
		}
		table.add(line);

		PageInfo<StudentInfo> pageInfo = listStudentInfos(0, 0, sCandidateNum, sStudentName, sNativePlace, sEnrolMajor,
				sDataFlag);
		List<StudentInfo> list = pageInfo.getList();
		if (list != null && list.size() > 0) {
			for (StudentInfo studentInfo : list) {
				line = new ArrayList<>();
				for (String head : headArr) {
					String sValue = "";
					Field field = null;
					try {
						// 在父类中没有获取到属性则去子类中取值，子类中依旧无法找到属性时，抛出异常
						try {
							field = StudentInfo.class.getDeclaredField(head);
						} catch (NoSuchFieldException e) {
							field = StudentInfo.class.getDeclaredField(head);
						}
						// 设置为可访问recruitInfo内部属性
						field.setAccessible(true);
						try {
							// 处理特殊字段数据：枚举、时间
							if (head.equals("sEnrolMajor")) {
								// 如果是报考专业，则调用字典查询接口
								sValue = (String) field.get(studentInfo);
								sValue = departmentService.getDeptByCode(sValue).getsFullName();
							} else if (head.equals("sPolitiis")) {
								// 如果是政治面貌，调用字典接口查询。zgdy-中共党员、zgybdy-中共预备党员、gqty-共青团员、qz-群众
								sValue = (String) field.get(studentInfo);
								if (StringUtils.hasText(sValue)) {
									sValue = dictionaryService.getDicByItemCodeAndKey("POLITICAL_STATUS", sValue)
											.getsItemValue();
								}
							} else if (head.equals("nAge")) {
								Integer result = (Integer) field.get(studentInfo);
								sValue = String.valueOf(result);
							} else {
								sValue = (String) field.get(studentInfo);
							}
						} catch (IllegalArgumentException e) {
							logger.error("考生信息导出出现异常（IllegalArgumentException）：：" + e);
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							logger.error("考生信息导出出现异常(IllegalAccessException):" + e);
							e.printStackTrace();
						}
					} catch (NoSuchFieldException e) {
						logger.error("考生信息导出出现异常(NoSuchFieldException):" + e);
						e.printStackTrace();
					} catch (SecurityException e) {
						logger.error("考生信息导出出现异常(SecurityException):" + e);
						e.printStackTrace();
					}
					line.add(sValue);
				}
				table.add(line);
			}
		}
		return table;
	}

}
