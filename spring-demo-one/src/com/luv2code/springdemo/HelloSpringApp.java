package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// Load spring config file
		ClassPathXmlApplicationContext context=	new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve bin
		Coach theCoach= context.getBean("myCoach",Coach.class);
		
		//Call method on the bin
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		//Close the context
		context.close();
	}

}
