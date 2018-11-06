package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
//		Load spring configuration class
		AnnotationConfigApplicationContext configClass = new AnnotationConfigApplicationContext(MyLoggerConfigJava.class, SportConfig.class);
		
//		Load beans
		SwimCoach waterCoach=configClass.getBean("swimCoach", SwimCoach.class);
		
//		Use bean methods		
		System.out.println(waterCoach.getDailyWorkout());
		System.out.println(waterCoach.getDailyFortune());
		System.out.println("Email:"+waterCoach.getEmail());
		System.out.println("Team:"+waterCoach.getTeam());
		
//		Close context
		configClass.close();
	}

}
