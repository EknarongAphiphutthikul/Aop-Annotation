package com.example.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.example.aop.annotation.TimeAnnotation;

@Service
public class ServiceTest {

	@TimeAnnotation(message = "ake")
	public String returnString(String msg) throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("test v2 service working");
		return msg;
	}
	
	@TimeAnnotation(message = "ake")
	public void voidReturn() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("void test v2 service working");
	}
	
	@TimeAnnotation(message = "ake")
	public void voidReturn2() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("void2 test v2 service working");
	}
	
	@TimeAnnotation(message = "ake")
	public void voidReturn3() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println("void3 test v2 service working");
	}
}
