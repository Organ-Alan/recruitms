package com.hgl.recruitms.service.test;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.common.test.BaseSpringContextTest;
import com.hgl.recruitms.common.util.JsonUtil;
import com.hgl.recruitms.enums.AuditStatusEnum;
import com.hgl.recruitms.model.AuditInfo;
import com.hgl.recruitms.model.Department;
import com.hgl.recruitms.service.CommonService;


/**  
 * ClassName: DictionaryServiceTest <br/>  
 * date: 2017年11月14日 上午11:05:59 <br/>  
 * Description：测试字典查询接口相关操作
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public class CommonServiceTest extends BaseSpringContextTest {
	static Logger logger = LoggerFactory.getLogger(CommonServiceTest.class);
	@Autowired
	private CommonService<Department> commonService;
	
	@Test
	public void checkDiffAndInsert() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException, IntrospectionException {
		Department department1 = new Department();
		department1.setnDeptNo(123);
		department1.setsDeptCode("test");
		department1.setsFullName("test");
		department1.setsShortName("test");
		
		Department department2 = new Department();
		department1.setnDeptNo(123);
		department1.setsDeptCode("test1");
		department1.setsFullName("test");
		department1.setsShortName("test");

		commonService.checkDiffAndInsert(department1, department2, null, "admin", "超级管理员");
	}
	
	@Test
	public void updateAuditStatus() {
		List<Integer> auditNoList = new ArrayList<>();
		//auditNoList.add(16051);
		//auditNoList.add(16050);
		auditNoList.add(1);
		
		List<Department> departments = new ArrayList<Department>();
		Department obj = new Department();
		obj.setsFullName("test");
		obj.setnDeptNo(123);
		departments.add(obj);
		
		List<Integer> nDeptNoList = new ArrayList<Integer>();
		nDeptNoList.add(1);
		commonService.updateAuditStatus(departments, auditNoList, AuditStatusEnum.REFUSE, nDeptNoList, "admin", "超级管理员");  //通过
		System.out.println(departments.toString());
	}
	
	@Test
	public void listAuditPage(){
		int pageIndex = 1;
		int pageSize = 10;
		String sDeptCode = "";
		String sFullName = "";
		String sStatus = "3";
		
		PageInfo<AuditInfo> list =  commonService.listAuditPage(pageIndex, pageSize, sDeptCode, sFullName, sStatus);
		System.out.println(JsonUtil.serialize(list));
	}
	
	@Test
	public void getPassAuditListByStatus(){
		List<Integer> sAuditNoList = new ArrayList<Integer>();
		sAuditNoList.add(276);
		sAuditNoList.add(277);
		sAuditNoList.add(278);
		
		List<AuditInfo> list = commonService.getPassAuditListByStatus(sAuditNoList);
		System.out.println(list);
	}
	
	@Test
	public void test() throws ParseException, NoSuchFieldException, SecurityException{
		Calendar now = Calendar.getInstance();
		Calendar nowDate = Calendar.getInstance();
		nowDate.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		System.out.println(nowDate.getTime());
	}
}
