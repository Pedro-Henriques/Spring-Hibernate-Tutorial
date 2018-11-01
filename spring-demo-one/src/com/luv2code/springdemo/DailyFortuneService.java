package com.luv2code.springdemo;

public class DailyFortuneService implements HappyFortuneService{

	@Override
	public String getDailyFortune() {
		return "Today is your lucky day!";
	}

}
