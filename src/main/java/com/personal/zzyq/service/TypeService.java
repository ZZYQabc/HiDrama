package com.personal.zzyq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.zzyq.bean.Type;
import com.personal.zzyq.dao.TypeMapper;

@Service
public class TypeService {
	
	@Autowired
	private TypeMapper typeMapper;

	public List<Type> getTypes(){
		List<Type> list = typeMapper.selectByExample(null);
		return list;
	}

}
