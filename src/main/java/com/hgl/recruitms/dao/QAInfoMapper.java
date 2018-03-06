package com.hgl.recruitms.dao;

import com.hgl.recruitms.model.QAInfo;
import com.hgl.recruitms.model.QAInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QAInfoMapper {
    long countByExample(QAInfoExample example);

    int deleteByExample(QAInfoExample example);

    int deleteByPrimaryKey(Integer nQaId);

    int insert(QAInfo record);

    int insertSelective(QAInfo record);

    List<QAInfo> selectByExample(QAInfoExample example);

    QAInfo selectByPrimaryKey(Integer nQaId);

    int updateByExampleSelective(@Param("record") QAInfo record, @Param("example") QAInfoExample example);

    int updateByExample(@Param("record") QAInfo record, @Param("example") QAInfoExample example);

    int updateByPrimaryKeySelective(QAInfo record);

    int updateByPrimaryKey(QAInfo record);
}