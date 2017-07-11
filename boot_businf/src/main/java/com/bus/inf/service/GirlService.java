package com.bus.inf.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.inf.dao.auto.GirlMapper;
import com.bus.inf.dao.def.GirlDao;
import com.bus.inf.entity.auto.Girl; 

 
@Service
public class GirlService {
	
	@Autowired
	private GirlDao girlDao;
	@Autowired
	private GirlMapper girlMapper;
	

	public List<Map<String, Object>> queryList(Map<String, Object> map) {
		return girlDao.queryList(map);
	} 
	
	public int add(Girl record) {
		return girlMapper.insert(record);
	} 

	public int del(long id) {
		return girlMapper.deleteByPrimaryKey(id);
	} 
	public int update(Girl record) {
		return girlMapper.updateByPrimaryKeySelective(record);
	} 

	public Girl query(long id) {
		return girlMapper.selectByPrimaryKey(id);
	} 
}
