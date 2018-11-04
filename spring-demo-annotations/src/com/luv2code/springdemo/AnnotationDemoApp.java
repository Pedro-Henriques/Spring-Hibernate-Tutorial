package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
//		Load spring config file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");

//		Load bean
		Coach sillyCoach= context.getBean("tennisCoach", Coach.class);
		Coach chessCoach=context.getBean("chessCoach", Coach.class);
		
//		Use bean methods
		System.out.println( sillyCoach.getDailyWorkout());
		System.out.println("I am a "+chessCoach.getClass()+" and the daily workout is:"+chessCoach.getDailyWorkout());
		
//		Close context
		context.close();
	}

}
