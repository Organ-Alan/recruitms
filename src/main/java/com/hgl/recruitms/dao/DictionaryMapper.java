package com.hgl.recruitms.dao;

import com.hgl.recruitms.model.Dictionary;
import com.hgl.recruitms.model.DictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**  
 * ClassName: DictionaryMapper <br/>  
 * date: 2017年11月14日 上午10:48:49 <br/>  
 * Description：字典数据交互层
 * @author huanggl  
 * @version   
 * Copyright (c) 2017, 黄光亮毕业设计----All Rights Reserved.  
 */
public interface DictionaryMapper {
    long countByExample(DictionaryExample example);

    int deleteByExample(DictionaryExample example);

    int deleteByPrimaryKey(Integer nDictNo);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    List<Dictionary> selectByExample(DictionaryExample example);

    Dictionary selectByPrimaryKey(Integer nDictNo);

    int updateByExampleSelective(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    int updateByExample(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}