package com.personal.zzyq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personal.zzyq.bean.Msg;
import com.personal.zzyq.bean.Type;
import com.personal.zzyq.service.TypeService;

//处理和类型有关的请求
@Controller
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	//返回所有类型信息
	@RequestMapping("/types")
	@ResponseBody
	public Msg getType() {
		//查出的所有类型信息
		List<Type> list = typeService.getTypes();
		return Msg.success().add("types", list);
	}

}
