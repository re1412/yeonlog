package com.yeon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class YeonLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(YeonLogApplication.class, args);
	}

}


