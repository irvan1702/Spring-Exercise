package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner printAll(ApplicationContext ctx) {
		return args -> {
			System.out.println("Hello World");
			String[] beansName = ctx.getBeanDefinitionNames();
			for (String beanName : beansName) {
				System.out.println(beanName);
			}
		};
	}

	@Bean
	CommandLineRunner printMessage(HelloWorld component) {
		return args -> {
			component.setMessage("Hello Component");
			component.printMessage();
		};
	}
}
