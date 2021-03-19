package com.example.aop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.aop.annotation.CustomAnnotation;
import com.example.aop.model.Request1Model;
import com.example.aop.model.Request2Model;
import com.example.aop.model.Request3Model;
import com.example.aop.model.Request4Model;
import com.example.aop.model.ResponseModel;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@PostMapping("/test1")
	public @ResponseBody ResponseModel test1(@RequestBody Request1Model request1) {
		return ResponseModel.builder().msg("test1").build();
	}
	
	@PostMapping("/test2")
	@CustomAnnotation
	public @ResponseBody ResponseModel test2(HttpServletRequest request, @RequestBody Request2Model input, HttpServletResponse response) {
		return ResponseModel.builder().msg("test2").build();
	}
	
	@PostMapping("/test3")
	public @ResponseBody ResponseModel test3(@RequestBody Request3Model request3) {
		return ResponseModel.builder().msg("test3").build();
	}
	
	@PostMapping("/test4")
	@CustomAnnotation
	public @ResponseBody ResponseModel test4(@RequestBody Request4Model request4) {
		return ResponseModel.builder().msg("test4").build();
	}
}
