package com.puppy.animals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AnimalsHomeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(AnimalsHomeApplication.class, args);
	}

}
