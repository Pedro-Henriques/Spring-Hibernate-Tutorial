package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("Sport.properties")
public class SportConfig {
	
//	Define bean for sad fortune service
	@Bean
	public FortuneService sadFortuneService()
	{
		return new SadFortuneService();
	}

//	Define bean for swim coach and inject dependency
	@Bean
	public Coach swimCoach(FortuneService theFortuneService)
	{
		return new SwimCoach(sadFortuneService());
	}
}
