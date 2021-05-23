package com.example.aop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.aop.annotation.TimeAnnotation;
import com.example.aop.model.Request2Model;
import com.example.aop.model.ResponseModel;
import com.example.aop.service.ServiceTest;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("v2")
public class RestController2 {
	
	@Autowired
	private ServiceTest serviceTest;
	
	@PostMapping("/test2")
	@TimeAnnotation(message = "ake")
	public @ResponseBody ResponseModel test2(HttpServletRequest request, @RequestBody Request2Model input, HttpServletResponse response) throws InterruptedException {
		serviceTest.voidReturn();
		serviceTest.voidReturn2();
		serviceTest.voidReturn3();
		return ResponseModel.builder().msg(serviceTest.returnString("test2 v2")).build();
	}
}
