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
	
//	add an init method
	public void doMyStartUpStuff()
	{
		System.out.println("TrackCoach: inside method doMyStartUpStuff");
	}
	
//	add a destroy method
	public void doMyCleanUpStuff()
	{
		System.out.println("TrackCoach: inside method doMyCleanUpStuff");
	}
}
