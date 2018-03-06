package com.hgl.recruitms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hgl.recruitms.model.AuditInfo;
import com.hgl.recruitms.model.AuditInfoExample;

public interface AuditInfoMapper {
	long countByExample(AuditInfoExample example);

	int deleteByExample(AuditInfoExample example);

	List<AuditInfo> listAuditPage(@Param("sDeptCode") String sDeptCode,
			@Param("sFullName") String sFullName, @Param("sStatus") String sStatus);

	int insert(AuditInfo record);

	int insertSelective(AuditInfo record);

	List<AuditInfo> selectByExample(AuditInfoExample example);

	int updateByExampleSelective(@Param("record") AuditInfo record, @Param("example") AuditInfoExample example);

	int updateByExample(@Param("record") AuditInfo record, @Param("example") AuditInfoExample example);
}