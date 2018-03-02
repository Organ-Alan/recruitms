package com.hgl.recruitms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgl.recruitms.dao.DictionaryMapper;
import com.hgl.recruitms.model.Dictionary;
import com.hgl.recruitms.model.DictionaryExample;
import com.hgl.recruitms.service.TestService;
@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	DictionaryMapper testMapper;
	
	public List<Dictionary> select(){
		DictionaryExample example = new DictionaryExample();
		example.createCriteria().andNDictNoIsNotNull();
		return testMapper.selectByExample(example);
	}
}
