package com.bus.inf.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bus.inf.common.annotation.SysLogInf;
import com.bus.inf.entity.auto.Girl;
import com.bus.inf.service.GirlService; 

/**
 * @date 2017年7月10日 上午9:21:44
 */
@Controller
@RequestMapping("/girl")
public class GirlController {
	
    private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	@Autowired
	private GirlService girlService;
	

	@ResponseBody
	@RequestMapping("/list")
	public String list(Map<String, Object> params){ 
		List<Map<String, Object>> list = girlService.queryList(params); 
		return JSONObject.toJSONString(list);
	}
	
 
	@RequestMapping(value = "/add",produces = "text/html;charset=UTF-8") 
	@ResponseBody
	public String add(Girl girl){ 
		int ret = girlService.add(girl);
		return ""+ret;
	}
	

	@RequestMapping(value = "/del",produces = "text/html;charset=UTF-8") 
	@ResponseBody
	public String del(long id){ 
		int ret = girlService.del(id);
		return ""+ret;
	}
	

	@RequestMapping(value = "/update",produces = "text/html;charset=UTF-8") 
	@ResponseBody
	public String update(Girl girl){ 
		int ret = girlService.update(girl);
		return ""+ret;
	}

	@SysLogInf("查询girl")
	@RequestMapping(value = "/query",produces = "text/html;charset=UTF-8") 
	@ResponseBody
	public String query(long id){ 
		Girl girl = girlService.query(id);
		logger.error("----====-id-{}--"+JSONObject.toJSONString(girl),id);
		return JSONObject.toJSONString(girl);
	}
	
}
