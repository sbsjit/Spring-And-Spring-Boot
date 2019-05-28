package com.sushree.sahayatri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SahayatriApplication {

	public static void main(String[] args) {
		SpringApplication.run(SahayatriApplication.class, args);
	}

}
