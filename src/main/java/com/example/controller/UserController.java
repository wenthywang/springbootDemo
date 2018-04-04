package com.example.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.People;
import com.example.service.PeopleService;
import com.example.util.DBID;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/people")
public class UserController {
	@Autowired
	private PeopleService peopleService;

	protected static Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postUser(@RequestBody People p) {
		// 处理"/users/"的POST请求，用来创建User
		p.setId(DBID.getID());
		p.setInsertTime(System.currentTimeMillis());
		JSONObject obj = new JSONObject();
		obj.put("status", false);
		obj.put("msg", "添加失败");
		try {
			peopleService.insertPeople(p);
			obj.put("status", true);
			obj.put("msg", "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj.toJSONString();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<People> getUser() {
		// 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
		// url中的id可通过@PathVariable绑定到函数的参数中
		List<People> pList = peopleService.getPeopleList();
		for (People people : pList) {
			Long insertTime = people.getInsertTime();
			Long updateTime = people.getUpdateTime();
			if (insertTime != null) {
				people.setInsertTime_format(DateFormatUtils.format(insertTime, "yyyy-MM-dd HH:mm:ss"));
			}
			if (updateTime != null) {
				people.setUpdateTime_format(DateFormatUtils.format(updateTime, "yyyy-MM-dd HH:mm:ss"));
			}
		}
		return pList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable String id, @RequestBody People p) {
		// 处理"/users/{id}"的PUT请求，用来更新User信息
		People pT = peopleService.getPeopleById(id);
		pT.setUpdateTime(System.currentTimeMillis());
		if (p.getAge() != null) {
			pT.setAge(p.getAge());
		}
		if (StringUtils.isNotBlank(p.getName())) {
			pT.setName(p.getName());
		}
		JSONObject obj = new JSONObject();
		obj.put("status", false);
		obj.put("msg", "添加失败");
		try {
			peopleService.updatePeople(pT);
			obj.put("status", true);
			obj.put("msg", "更新成功");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj.toJSONString();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable String id) {
		// 处理"/users/{id}"的DELETE请求，用来删除User
		JSONObject obj = new JSONObject();
		obj.put("status", false);
		obj.put("msg", "删除失败");
		try {
			int deleCount = peopleService.deletePeople(id);
			if (deleCount > 0) {
				obj.put("status", true);
				obj.put("msg", "删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj.toJSONString();
	}

}
