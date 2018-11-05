package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private Random myRandom=new Random();
	
//	Create array of strings
	String[] fortuneArray= {
			"Beware the wolf in sheep's clothing",
			"Dilligence is the mother of good luck",
			"The journey is the reward"
	};
	
	
	

	@Override
	public String getFortune() {
//		return random string as fortune			
		int index=myRandom.nextInt(fortuneArray.length);
		return fortuneArray[index];
	}

}
