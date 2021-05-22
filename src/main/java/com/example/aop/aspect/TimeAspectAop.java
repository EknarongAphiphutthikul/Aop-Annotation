package com.example.aop.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.aop.annotation.TimeAnnotation;
import com.example.aop.model.Request2Model;

@Aspect
@Component
public class TimeAspectAop {

	@Pointcut("@annotation(com.example.aop.annotation.TimeAnnotation)")
	private void timeAnnotationPointCut() {
	}

	@Around(value = "timeAnnotationPointCut() && args(*, request, *)")
	public @ResponseBody Object timeController(ProceedingJoinPoint pjp, Request2Model request) throws Throwable {
		Object response = null;
		long t1 = System.currentTimeMillis();
		response = pjp.proceed();
		System.out.println("controller total time : " + (System.currentTimeMillis() - t1));
		return response;
	}
	
	@Around(value = "timeAnnotationPointCut() && execution(* com.example.aop.service.ServiceTest.*(..))")
	public Object timeService(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		long t1 = System.currentTimeMillis();
		result = pjp.proceed();
		System.out.println("service total time : " + (System.currentTimeMillis() - t1));
		return result;
	}
	
	@Around(value = "timeAnnotationPointCut() && execution(void com.example.aop.service.ServiceTest.*(..))")
	public void timeVoidService(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
	    Method method = signature.getMethod();
	    TimeAnnotation timeAnno = method.getAnnotation(TimeAnnotation.class);
		System.out.println("msg : " + timeAnno.message());
		long t1 = System.currentTimeMillis();
		pjp.proceed();
		System.out.println("service void total time : " + (System.currentTimeMillis() - t1));
	}
}
