package com.example.aop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.aop.annotation.ReturnValueAnnotation;
import com.example.aop.model.Request2Model;
import com.example.aop.model.ResponseModel;
import com.example.aop.service.ServiceTestReturn;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("v3")
public class RestController3 {
	
	@Autowired
	private ServiceTestReturn serviceTestReturn;
	
	@PostMapping("/testReturn")
	@ReturnValueAnnotation(message = "ake")
	public @ResponseBody ResponseModel test2(HttpServletRequest request, @RequestBody Request2Model input, HttpServletResponse response) throws InterruptedException {
		System.out.println(serviceTestReturn.returnInt());
		System.out.println(serviceTestReturn.returnBoolean());
		System.out.println(serviceTestReturn.returnDouble());
		System.out.println(serviceTestReturn.returnObject());
		System.out.println(serviceTestReturn.returnInteger());
		System.out.println(serviceTestReturn.returnBooleanObject());
		System.out.println(serviceTestReturn.returnDoubleObject());
		System.out.println(serviceTestReturn.returnNull());
		System.out.println(serviceTestReturn.returnList());
		return ResponseModel.builder().msg(serviceTestReturn.returnString("testReturn v3")).build();
	}
}
