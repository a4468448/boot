package com.bus.inf.common.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.bus.inf.common.Utils.HttpContextUtils;
import com.bus.inf.common.Utils.IPUtils;
import com.bus.inf.common.annotation.SysLogInf;
import com.bus.inf.dao.auto.SysLogMapper;
import com.bus.inf.entity.auto.SysLog;


/**
 * 系统日志，切面处理类
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017年3月8日 上午11:07:35
 */
@Aspect
@Component
public class SysLogAspect {
	@Autowired
	private SysLogMapper sysLogMapper;
	
	@Pointcut("@annotation(com.bus.inf.common.annotation.SysLogInf)")
	public void logPointCut() { 
		
	}
	
	@Before("logPointCut()")
	public void saveSysLog(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		
		SysLog sysLog = new SysLog();
		SysLogInf sysloginf = method.getAnnotation(SysLogInf.class);
		if(sysloginf != null){
			//注解上的描述 
			sysLog.setOperation(sysloginf.value());
		}
		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");
		//请求的参数
		Object[] args = joinPoint.getArgs(); 
		sysLog.setParams(JSONObject.toJSONString(args[0]));
		//获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		//设置IP地址
		sysLog.setIp(IPUtils.getIpAddr(request)); 
		
		sysLog.setCreateDate(new Date());
		//保存系统日志
		sysLogMapper.insertSelective(sysLog);
	}
	
}
