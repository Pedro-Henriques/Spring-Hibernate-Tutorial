package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class ChessCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Rook takes Queen";
	}

}
