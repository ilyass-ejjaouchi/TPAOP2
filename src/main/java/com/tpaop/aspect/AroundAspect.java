package com.tpaop.aspect;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.tpaop.beans.Compte;

@Component
public class AroundAspect implements MethodInterceptor {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		String methodeName = invocation.getMethod().getName();
		String arguments = Arrays.toString(invocation.getArguments());
		double montant = Double.parseDouble(arguments.substring( 1, arguments.length() - 1 )); 
		Compte compte = (Compte) invocation.getThis();
		
		logger.info("Method name : " + methodeName );
		logger.info("Method arguments : " +Arrays.toString(invocation.getArguments()));
		if (methodeName == "debiter") {
			if (compte.getSolde() > montant ) {
				logger.info("debiter " + montant +" du compte");
				Object result = invocation.proceed();
				return result;
			}else {
				logger.error("erreur le solde est insufisant");
			}
		}else if (methodeName == "approvisionner") {
			logger.info("verser " + montant +" au compte");
		} 
		
		return null;
	}


}