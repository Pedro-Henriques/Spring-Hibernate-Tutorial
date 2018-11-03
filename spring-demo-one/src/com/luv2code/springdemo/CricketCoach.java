package com.luv2code.springdemo;

public class CricketCoach implements Coach {

//	Field injection by reference	
	private HappyFortuneService fortuneService;
	
//	Fields injected by literal value
	private String emailAddress;
	private String team;
	
	
	public CricketCoach()
	{
		System.out.println("Cricket Coach:Inside no arg constructor");
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Cricket Coach:Inside setter method - Email Address");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Cricket Coach:Inside setter method - Team");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15min";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

//	method for setter injection
	public void setFortuneService(HappyFortuneService fortuneService) {
		System.out.println("Cricket Coach:Inside setter method - Set Fortune Service");
		this.fortuneService = fortuneService;
	}

	
}
