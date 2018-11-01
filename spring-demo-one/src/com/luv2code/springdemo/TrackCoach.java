package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private HappyFortuneService fortuneService;
	
	public TrackCoach(HappyFortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it: "+fortuneService.getDailyFortune();
	}

}
