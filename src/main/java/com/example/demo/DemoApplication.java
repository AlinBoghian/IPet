package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
@EnableMongoRepositories

public class DemoApplication {
//	@Autowired
//	MyRepository repo;
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ResponseEntity<User> runner(@RequestBody MyRepository repo, MongoTemplate template) {

			User user = new User(
					"Cristina@gmail.com",
					"Cristina",
					"1234",
					true
			);

		System.out.println("POST");
		repo.insert(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

}