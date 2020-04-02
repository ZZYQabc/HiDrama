package com.personal.zzyq.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.personal.zzyq.bean.Drama;
import com.personal.zzyq.bean.Msg;
import com.personal.zzyq.service.DramaService;

//处理剧集CRUD请求

@Controller
public class DramaController {

	@Autowired
	DramaService dramaService;

	
	//单个批量二合一
	//批量删除1-2-3
	//单个删除1
	@ResponseBody
	@RequestMapping(value="/dra/{ids}",method = RequestMethod.DELETE)
	public Msg deleteDra(@PathVariable("ids")String ids) {
		if (ids.contains("-")) {
			//批量删除
			List<Integer> del_ids = new ArrayList<>();
			String[] str_idS = ids.split("-");
			//组装id集合
			for (String string : str_idS) {
				del_ids.add(Integer.parseInt(string));
			}
			dramaService.deleteBatch(del_ids);
		}else {
			Integer id = Integer.parseInt(ids);
			dramaService.deleteDra(id);
		}
		
		return Msg.success();
	}
	
	
	/*
	 * 如果直接发ajax=PUT形式的请求 //封装的数据 //Drama [dramaId=1027, userId=null, typeId=null,
	 * dramaName=null, dramaWatching=null, dramaCurrent=null, dramaCurrentAdd=null,
	 * dramaAll=null, type=null] //问题 //请求体中有数据但drama封装不上 //update drama where
	 * drama_id = 1027 //原因toncat
	 * 将请求体中的数据封装一个map，request.getParameter（“draName”）就会从map中取值
	 * 而SpringMvc封装pojo对象的时候会把pojo每个属性的值request.getParameter（“draName”）
	 * AJAX发送PUT请求引发的血案 PUT请求，请求体中的数据request.getParameter（“draName”）拿不到
	 * tomcat一看是PUT不会封装请求体中的数据为map，只有POST形式的请求才封装请求体为map
	 */
	// 剧集更新
	@ResponseBody
	@RequestMapping(value = "/dra/{dramaId}", method = RequestMethod.PUT)
	public Msg saveDra(Drama drama) {
		//System.out.println("将要更新的剧集数据：" + drama);
		dramaService.updateDra(drama);
		return Msg.success();
	}

	// 根据id查询剧集
	@RequestMapping(value = "/dra/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getDra(@PathVariable("id") Integer id) {
		Drama drama = dramaService.getDra(id);
		return Msg.success().add("dra", drama);
	}

	// 检查剧集名称是否重复
	@ResponseBody
	@RequestMapping("/cheskuser")
	public Msg cheskuser(@RequestParam("draName") String draName) {
		// 先判断剧集是否合法

		if (draName == null || draName == "") {
			return Msg.fail().add("va_msg", "剧集名称不可为空哟Σ (ﾟДﾟ;) ");
		}

		// 数据库校验
		boolean b = dramaService.checkUser(draName);
		if (b) {
			return Msg.success();
		} else {
			return Msg.fail().add("va_msg", "已经有了换一个吧(￣.￣)");
		}

	}

	// 支持jsr303校验
	// 导入Hibernate-Validator包
	// 剧集保存
	@RequestMapping(value = "/dra", method = RequestMethod.POST)
	@ResponseBody
	public Msg saveDra(@Valid Drama drama, BindingResult result) {
		if (result.hasErrors()) {
			// 校验失败应该返回失败，在模态框中显示校验失败的信息
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				// System.out.println("错误的字段名：" + fieldError.getField());
				// System.out.println("错误的信息：" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		} else {
			dramaService.saveDra(drama);
			return Msg.success();
		}

	}

	// 导入jackson包
	@RequestMapping("/dramas")
	@ResponseBody
	public Msg getDramasWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 这不是一个分页查询
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页大小
		PageHelper.startPage(pn, 5);
		// startPage后面紧跟的查询就是一个分页查询
		List<Drama> dramas = dramaService.getAll();
		// 使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了
		// 封装了详细的分页信息，包括有我们查询出来的数据,传入连续显示的页数
		PageInfo page = new PageInfo(dramas, 5);
		return Msg.success().add("pageInfo", page);
	}

	// 查询员工数据（分页查询）
	// @RequestMapping("/dramas")
	public String getDramas(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {

		// 这不是一个分页查询
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页大小
		PageHelper.startPage(pn, 5);
		// startPage后面紧跟的查询就是一个分页查询
		List<Drama> dramas = dramaService.getAll();
		// 使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了
		// 封装了详细的分页信息，包括有我们查询出来的数据,传入连续显示的页数
		PageInfo page = new PageInfo(dramas, 5);
		model.addAttribute("pageInfo", page);

		return "list";
	}
}
