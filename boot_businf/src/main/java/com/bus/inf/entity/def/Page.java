package com.bus.inf.entity.def;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageHelper;

/**
 * 分页
 */
public class Page {

	private int page;//当前页
	
	private int rows;//当前条数 
	
	private String sort;//排序字段
	
	private String order;//ASC DESC

	/**
	 * 开始分页
	 */
	public void startPage(){
        PageHelper.startPage(this.page,this.rows);
    }

	/**
	 * 开始分页 排序
	 */
    public  void startPageOrderBy(){
		if(null == this.sort || null == this.order){
			PageHelper.startPage(this.page,this.rows);
		}else{
			PageHelper.startPage(this.page,this.rows, this.sort + " " + this.order);
		}
    }
    /**
     * 得到查询总条数
     * @param list
     * @return
     */
    public  long getTotal(List<?>list){ 
    	if(list != null && list.size()>0){
        	((com.github.pagehelper.Page<?>)list).getPages();
        	return ((com.github.pagehelper.Page<?>)list).getTotal();
    	}else{
    		return 0l;
    	}

    }

    /**
     * 得到总页数
     * @param list
     * @return
     */
    public  long getPages(List<?>list){ 
    	if(list != null && list.size()>0){
        	return ((com.github.pagehelper.Page<?>)list).getPages();
    	}else{
    		return 0l;
    	}

    }
    
	/**
	 * 无分页的List对象
	 * @param list
	 * @return
     */
	public String protogeneticToJSONString(List<?> list){
		JSONObject obj = new JSONObject();
		obj.put("total", list.size());
		obj.put("rows", list);
		//return obj.toString();
		return JSON.toJSONString(obj,SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 分页结果集
	 * @param list 为原始query后的结果集
	 * @return
     */
    public String toJSONString(List<?> list){
		JSONObject obj = new JSONObject();
		obj.put("total", getTotal(list));
		obj.put("rows", list);
		//return obj.toString();
	    return JSON.toJSONString(obj,SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 返回页面查询列表
	 * @param list 为原始query后的结果集
	 * @param response
	 * @throws IOException
     */
	public void responsePageList(List<?>list, HttpServletResponse response) throws IOException{
		writeToResponse(toJSONString(list),response);
	}

	/**
	 * 将字符串返回页面
	 * @param jsonString
	 * @param response
	 * @throws IOException
     */
	private void writeToResponse(String jsonString,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonString);
		response.getWriter().flush();
	}

	/**
     *返回页面查询列表
     * @param total 总条数
     * @param list 查询数据库得到集合
     * @throws IOException 
     */
    public void responsePageList(List<?>list,Long total,HttpServletResponse response) throws IOException{
		JSONObject obj = new JSONObject();
		obj.put("total", total);
		obj.put("rows", list);
		writeToResponse(obj.toString(),response);
    }
    
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
