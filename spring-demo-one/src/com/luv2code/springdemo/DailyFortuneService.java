package com.luv2code.springdemo;

import java.util.Random;

public class DailyFortuneService implements HappyFortuneService{

	private String[] fortuneArray;
	
	public DailyFortuneService(String fortunes) {		
		fortuneArray=fortunes.split("\\,");
	}

	@Override
	public String getDailyFortune() {
		 int rnd = new Random().nextInt(fortuneArray.length);
		    return fortuneArray[rnd];
	}

}
