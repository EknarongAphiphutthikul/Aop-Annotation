package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.aop.model.Request2Model;

@Aspect
@Component
public class ReturnAspectAop {

	@Pointcut("@annotation(com.example.aop.annotation.ReturnValueAnnotation)")
	private void returnValueAnnotationPointCut() {
	}

	@Around(value = "returnValueAnnotationPointCut() && args(*, request, *)")
	public @ResponseBody Object timeController(ProceedingJoinPoint pjp, Request2Model request) throws Throwable {
		Object response = null;
		long t1 = System.currentTimeMillis();
		response = pjp.proceed();
		System.out.println("controller total time : " + (System.currentTimeMillis() - t1));
		return response;
	}
	
	@Around(value = "returnValueAnnotationPointCut() && execution(* com.example.aop.service.ServiceTestReturn.*(..))")
	public Object timeService(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		long t1 = System.currentTimeMillis();
		result = pjp.proceed();
		System.out.println("service return total time : " + (System.currentTimeMillis() - t1));
		return result;
	}
}
