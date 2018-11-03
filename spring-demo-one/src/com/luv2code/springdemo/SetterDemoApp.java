package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// Load spring config file
		ClassPathXmlApplicationContext context=	new ClassPathXmlApplicationContext("applicationContext.xml");

		//Retrieve bean from Container
		CricketCoach theCoach= context.getBean("myCricketCoach",CricketCoach.class);
		
		//Call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
//		Call method to test injected literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		//Close container
		context.close();
	}

}
