package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {

	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {		
		return "Train tackle";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
//	Random name for autowired method 
	@Autowired
	@Qualifier("happyFortuneService")
	public void testRandomNameAutowire(FortuneService theFortuneService)
	{
//		System.out.println(">>I'm in testRandomNameAutowire");
		fortuneService=theFortuneService;
	}

}
