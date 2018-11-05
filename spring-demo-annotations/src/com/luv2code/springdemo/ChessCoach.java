package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ChessCoach implements Coach {

	private FortuneService fortuneService;
	
	public ChessCoach() {
//		System.out.println("I'm in the Chess Coach constructor!");
	}
	
//	Create the setter method for injection
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService theFortuneService) {
//		System.out.println("I'm in the set Fortune Service method! Value:"+theFortuneService.getFortune());
		this.fortuneService = theFortuneService;
	}


	@Override
	public String getDailyWorkout() {
		return "Rook takes Queen";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
