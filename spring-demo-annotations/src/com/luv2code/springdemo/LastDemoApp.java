package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LastDemoApp {

	public static void main(String[] args) {
//		Load the configuration class
		AnnotationConfigApplicationContext configClass= new AnnotationConfigApplicationContext(TetrisConfig.class);
		
//		Load the desired bean
		Coach tetrisCoach= configClass.getBean("tetrisCoach", Coach.class);
		
//		Call method from the bean
		System.out.println("Tetris Coach says:"+tetrisCoach.getDailyWorkout());
		System.out.println("Fortune for today:"+tetrisCoach.getDailyFortune());
		
//		Close configclass
		configClass.close();
	}

}
