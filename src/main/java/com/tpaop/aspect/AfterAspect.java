package com.tpaop.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

@Component
public class AfterAspect implements AfterReturningAdvice {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		logger.info(" after la Méthode " + method.getName() + "() invoquée avec " + Arrays.toString(args));
	}
	
	

}