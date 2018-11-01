package com.luv2code.springdemo;

public class BaseballCoach implements Coach{

	private HappyFortuneService fortuneService;
	
	public BaseballCoach(HappyFortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	
	
	@Override
	public String getDailyWorkout()
	{
		return "Spend 30min on batting pratice";
	}


	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}
}
