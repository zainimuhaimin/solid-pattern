package com.zen.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// tambahkan componentScan basePackages agar aplikasi bisa render packages
@ComponentScan(basePackages = {"com.zen.pattern.*"})
public class PatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternApplication.class, args);
	}

}
