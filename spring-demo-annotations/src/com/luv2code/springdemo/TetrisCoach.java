package com.luv2code.springdemo;

public class TetrisCoach implements Coach {

	private FortuneService fortuneService;
	
	public TetrisCoach(FortuneService theFortuneService)
	{
		fortuneService=theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Give me 5 lines of awesome";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
