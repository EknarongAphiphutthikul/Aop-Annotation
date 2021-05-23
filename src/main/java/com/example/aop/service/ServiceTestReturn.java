package com.example.aop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.example.aop.annotation.ReturnValueAnnotation;
import com.example.aop.bean.BeanObject;

@Service
public class ServiceTestReturn {
	
	@ReturnValueAnnotation(message = "ake")
	public String returnString(String msg) throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("return String service working");
		return msg;
	}
	
	@ReturnValueAnnotation(message = "ake")
	public int returnInt() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("return int service working");
		return 1;
	}
	
	@ReturnValueAnnotation(message = "ake")
	public boolean returnBoolean() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("return boolean service working");
		return true;
	}
	
	@ReturnValueAnnotation(message = "ake")
	public double returnDouble() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("return double service working");
		return 12.23;
	}
	
	@ReturnValueAnnotation(message = "ake")
	public Object returnObject() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("return Object service working");
		return BeanObject.builder().msg("return Object").build();
	}
	
	@ReturnValueAnnotation(message = "ake")
	public Integer returnInteger() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("return Integer service working");
		return 1;
	}
	
	@ReturnValueAnnotation(message = "ake")
	public Boolean returnBooleanObject() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("return Boolean service working");
		return true;
	}
	
	@ReturnValueAnnotation(message = "ake")
	public Double returnDoubleObject() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("return Double service working");
		return 12.23;
	}
	
	@ReturnValueAnnotation(message = "ake")
	public BeanObject returnNull() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("return null service working");
		return null;
	}
	
	@ReturnValueAnnotation(message = "ake")
	public List<BeanObject> returnList() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("return List service working");
		List<BeanObject> list = new ArrayList<BeanObject>();
		list.add(BeanObject.builder().msg("Return List").build());
		return list;
	}
	
	
	// *****  NOT WORK *****//
	public Map<String, BeanObject> returnMapTestNotFirstMethod() throws InterruptedException {
		return returnMap();
	}
	
	@ReturnValueAnnotation(message = "ake")
	public Map<String, BeanObject> returnMap() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("return map service working");
		Map<String , BeanObject> map = new HashMap<String, BeanObject>();
		map.put("result", BeanObject.builder().msg("Return List").build());
		return map;
	}

}
