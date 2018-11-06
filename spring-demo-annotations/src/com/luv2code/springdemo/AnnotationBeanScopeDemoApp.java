package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

//		Load spring configuration file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		Retrieve the bean from the container
		Coach theCoach= context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach= context.getBean("tennisCoach", Coach.class);
		
		boolean result=(theCoach==alphaCoach);
		
//		Compare if fields are pointing to the same object
		System.out.println("Result is:"+result);
		System.out.println("Memory location for theCoach:"+theCoach);
		System.out.println("Memory location for alphaCoach"+alphaCoach);
		
//		Close the container
		context.close();
	}

}
