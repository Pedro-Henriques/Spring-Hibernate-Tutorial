package com.luv2code.springdemo;

public class GolfCoach implements Coach {

	private HappyFortuneService myFortuneService;
	
	public GolfCoach(HappyFortuneService fortuneService) {
		myFortuneService=fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your putting skills for 2 hours today";
	}

	@Override
	public String getDailyFortune() {
		return myFortuneService.getDailyFortune();
	}
	
//	Init method
	public void init()
	{
		System.out.println("I'm inside Golf Coach init method");
	}
	
//	Destroy method
	public void cleanUp()
	{
		System.out.println("I'm inside Golf Coach destroy method");
	}

}
