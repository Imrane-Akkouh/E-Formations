package com.apollo.ApolloProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApolloProjectApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApolloProjectApplication.class, args);
	}

	// that Bean help us to check how many beans that are running in the background

	/*
	 * @Bean public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	 * return args -> {
	 * 
	 * System.out.println("Let's inspect the beans provided by Spring Boot:");
	 * 
	 * String[] beanNames = ctx.getBeanDefinitionNames(); Arrays.sort(beanNames);
	 * 
	 * System.out.println(beanNames.length);
	 * 
	 * for (String beanName : beanNames) { System.out.println(beanName); }
	 * 
	 * }; }
	 */
}
