package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
//		Load spring config file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");

//		Load beans
//		TennisCoach has Autowired constructor 
//		ChessCoach has Autowired setter
//		BasketballCoach has randomly named method to test autowired(it will look for a bean that implements the specified interface)
//		CrossfitCoach has field injection
//		GymCoach has qualifiers for autowired injection 
//		Coach sillyCoach= context.getBean("tennisCoach", Coach.class);
//		Coach chessCoach=context.getBean("chessCoach", Coach.class);
//		Coach basketballCoach=context.getBean("basketballCoach", Coach.class);
//		Coach crossfitCoach=context.getBean("crossfitCoach", Coach.class);
		Coach gymCoach=context.getBean("gymCoach", Coach.class);
		
//		Use bean methods
//		System.out.println( sillyCoach.getDailyWorkout());
//		System.out.println(sillyCoach.getDailyFortune());
//		System.out.println("I am a "+chessCoach.getClass()+" and the daily workout is:"+chessCoach.getDailyWorkout());
//		System.out.println("Today's fortune:"+chessCoach.getDailyFortune());		
//		System.out.println(basketballCoach.getDailyWorkout());
//		System.out.println(basketballCoach.getDailyFortune());
//		System.out.println(crossfitCoach.getDailyWorkout());
//		System.out.println(crossfitCoach.getDailyFortune());
		System.out.println(gymCoach.getDailyWorkout());
		System.out.println(gymCoach.getDailyFortune());
		System.out.println(gymCoach.getDailyFortune());
		System.out.println(gymCoach.getDailyFortune());
		System.out.println(gymCoach.getDailyFortune());
		
//		Close context
		context.close();
	}

}
