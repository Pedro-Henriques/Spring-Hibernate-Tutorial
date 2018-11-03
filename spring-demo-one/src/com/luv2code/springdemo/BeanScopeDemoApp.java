package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// Load the Spring Config file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// Retrieve beans from container
		Coach theCoach= context.getBean("myCoach", Coach.class);
		Coach alphaCoach= context.getBean("myCoach", Coach.class);
	
		//Check if it is th same bean
		boolean isSameCoach=(theCoach==alphaCoach);
		
		//Print results
		System.out.println("\nAre these pointing to the same object?" + isSameCoach);
		System.out.println("\nMemory location for theCoach"+ theCoach.toString());
		System.out.println("\nMemory location for alphaCoach"+ alphaCoach.toString()+ "\n");
		
		//Close context
		context.close();
	}

}
