package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.aop.model.Request2Model;
import com.example.aop.model.Request4Model;
import com.example.aop.model.ResponseModel;

@Aspect
@Component
public class AspectAop {

	@Pointcut("@annotation(com.example.aop.annotation.CustomAnnotation)")
	private void customAnnotationPointCut() {
	}

	@Around(value = "customAnnotationPointCut() && args(*, request, *)")
	public @ResponseBody Object validateHeader(ProceedingJoinPoint pjp, Request2Model request) throws Throwable {
		Object response = null;
		if (request.getHeader() == null || request.getHeader().length() == 0) {
			response = ResponseModel.builder().msg("Header invalid.").build();
		}
		if (null == response) {
			response = pjp.proceed();
		}
		return response;
	}
	
	@Around(value = "customAnnotationPointCut() && args(request, ..)")
	public @ResponseBody Object validateHeader(ProceedingJoinPoint pjp, Request4Model request) throws Throwable {
		Object response = null;
		if (request.getHeader() == null || request.getHeader().length() == 0) {
			response = ResponseModel.builder().msg("Header invalid.").build();
		}
		if (null == response) {
			response = pjp.proceed();
		}
		return response;
	}
}
