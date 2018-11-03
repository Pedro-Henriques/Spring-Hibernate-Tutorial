package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeHelloSpringApp {

	public static void main(String[] args) {
		// Load spring config file
		ClassPathXmlApplicationContext context=	new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve bean
		Coach theCoach= context.getBean("myGolfCoach", Coach.class);
			
		// Test Fortune method:Call 3 times and check result
		System.out.println(theCoach.getDailyWorkout());
		for(int i=0;i<3;i++)
		{
			System.out.println(theCoach.getDailyFortune());
		}
		
		// Close Container
		context.close();
	}

}
