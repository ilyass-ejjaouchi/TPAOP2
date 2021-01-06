package com.tpaop.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
public class BeforeAspect implements MethodBeforeAdvice {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.info(" before la Méthode " + method.getName() + "() invoquée avec " + Arrays.toString(args));	
	}

}