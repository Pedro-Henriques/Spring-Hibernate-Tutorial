package com.luv2code.springdemo;

public class FootballCoach implements Coach {

private HappyFortuneService fortuneService;
	
	public FootballCoach(HappyFortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "30m technique work and 30min shooting";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}
