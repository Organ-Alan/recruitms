package com.hgl.recruitms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hgl.recruitms.common.bean.EnrolmentInfo;
import com.hgl.recruitms.model.Department;
import com.hgl.recruitms.model.DepartmentExample;

public interface DepartmentMapper {
    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer nDeptNo);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer nDeptNo);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    EnrolmentInfo selectEnrolmentInfo();
    
    List<Department> accountDepartments();
}