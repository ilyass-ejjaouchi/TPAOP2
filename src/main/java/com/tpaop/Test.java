package com.tpaop;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tpaop.beans.Icompte;

public class Test {
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		  ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
				Icompte cp = (Icompte) ctx.getBean("compteProxy");
				cp.approvisionner(100);
				cp.debiter(200);
	}
}
