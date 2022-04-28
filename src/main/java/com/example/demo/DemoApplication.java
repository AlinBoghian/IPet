package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repositoru.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication(scanBasePackages = {
		"com.example.demo", "com.example.demo.service", "com.example.demo.controller", "com.example.demo.model"
})

public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
//	@Bean
//	CommandLineRunner runner(@RequestBody UserRepository repo, MongoTemplate template) {
//		String email = "ekjbfjrefv@gmail.com";
//		return args -> {
//			User user = new User(
//					"ekjbfjrefv@gmail.com",
//					"Ahmed01",
//					"1234",
//					true
//			);
////			Query query = new Query();
////			query.addCriteria(Criteria.where("email").is(email));
////			List<User> users = template.find(query, User.class);
////			if(users.size() > 1) {
////				throw new IllegalStateException("found many users with email " + email);
////			} else
////				repo.insert(user);
//			repo.findUserByEmail(email).ifPresentOrElse(u -> {
//				throw new IllegalStateException("found many users with email " + email);
//			}, () -> {
//				repo.insert(user);
//			});
//		};
//	}

}