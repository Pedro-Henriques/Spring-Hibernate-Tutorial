package com.luv2code.springdemo;

public class LastFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "This is the end. Goodbye :)";
	}

}
