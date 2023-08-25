package com.notify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NotifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotifyApplication.class, args);
	}

}
