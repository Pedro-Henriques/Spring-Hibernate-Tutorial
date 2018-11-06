package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TetrisConfig {

	@Bean
	public FortuneService lastFortuneService()
	{
		return new LastFortuneService();
	}
	
	@Bean
	public Coach tetrisCoach( )
	{
		return new TetrisCoach(lastFortuneService()); 
	}
}
