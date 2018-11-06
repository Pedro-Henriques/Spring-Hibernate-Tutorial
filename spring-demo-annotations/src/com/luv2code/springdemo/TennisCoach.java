package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	@Autowired
	
	public TennisCoach(@Qualifier("happyFortuneService")FortuneService theFortuneservice)
	{
		System.out.println("Inside Tennis Coach constructor");
		fortuneService=theFortuneservice;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	
//	Init method for this class. This annotation replaces init-method on applicationContext.xml
	@PostConstruct
	private void afterBeanConstructor()
	{
		System.out.println("Do my startup stuff on afterBeanConstructor(). Replaces Init");
	}

//	Destroy method for this class. This annotation replaces init-method on applicationContext.xml
	@PreDestroy
	public void preDestructMethod()
	{
		System.out.println("Do my close stuff on preDestructMethod(). Replaces Destroy");
	}
}
