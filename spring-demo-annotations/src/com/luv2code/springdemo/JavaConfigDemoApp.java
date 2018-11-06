package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
//		Load spring configuration class
		AnnotationConfigApplicationContext configClass= new AnnotationConfigApplicationContext(SportConfig.class);
//		Load beans
//		Coach sillyCoach= configClass.getBean("tennisCoach", Coach.class);
		Coach waterCoach=configClass.getBean("swimCoach", Coach.class);
//		Use bean methods
//		System.out.println( sillyCoach.getDailyWorkout());
//		System.out.println(sillyCoach.getDailyFortune());
		
//		System.out.println(waterCoach.getDailyWorkout());
//		System.out.println(waterCoach.getDailyFortune());
		
//		Close context
		configClass.close();
	}

}
