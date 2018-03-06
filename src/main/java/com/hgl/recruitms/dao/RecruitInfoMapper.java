package com.hgl.recruitms.dao;

import com.hgl.recruitms.model.RecruitInfo;
import com.hgl.recruitms.model.RecruitInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecruitInfoMapper {
    long countByExample(RecruitInfoExample example);

    int deleteByExample(RecruitInfoExample example);

    int deleteByPrimaryKey(Integer nStudentId);

    int insert(RecruitInfo record);

    int insertSelective(RecruitInfo record);

    List<RecruitInfo> selectByExample(RecruitInfoExample example);

    RecruitInfo selectByPrimaryKey(Integer nStudentId);

    int updateByExampleSelective(@Param("record") RecruitInfo record, @Param("example") RecruitInfoExample example);

    int updateByExample(@Param("record") RecruitInfo record, @Param("example") RecruitInfoExample example);

    int updateByPrimaryKeySelective(RecruitInfo record);

    int updateByPrimaryKey(RecruitInfo record);
}