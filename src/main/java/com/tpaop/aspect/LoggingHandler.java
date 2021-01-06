package com.tpaop.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class LoggingHandler implements InvocationHandler {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private Object target;

	public LoggingHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		logger.info("Méthode " + method.getName() + "() invoquée avec " + Arrays.toString(args));
		Object result = method.invoke(target, args);
		logger.info("Méthode " + method.getName() + "() terminée par " + result);
		return result;
	}


}