package com.example.aop.service;

import org.springframework.stereotype.Service;

import com.example.aop.annotation.TimeAnnotation;

@Service
public class ServiceTest {

	@TimeAnnotation(message = "ake")
	public String returnString(String msg) {
		System.out.println("test v2 service working");
		return msg;
	}
	
	@TimeAnnotation(message = "ake")
	public void voidReturn() {
		System.out.println("void test v2 service working");
	}
}
