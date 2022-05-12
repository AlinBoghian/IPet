package com.example.demo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
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

//	@Bean
//	ResponseEntity<User> runner(@RequestBody MyRepository repo, MongoTemplate template) {
////		ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:admin@ipetcluster.kngmx.mongodb.net/test?retryWrites=true&w=majority");
////		MongoClientSettings settings = MongoClientSettings.builder()
////				.applyConnectionString(connectionString)
////				.serverApi(ServerApi.builder()
////						.version(ServerApiVersion.V1)
////						.build())
////				.build();
////		MongoClient mongoClient = MongoClients.create(settings);
////		MongoDatabase database = mongoClient.getDatabase("test");
//			User user = new User(
//					"Cristina@gmail.com",
//					"Cristina",
//					"1234",
//					true
//			);
//
//		System.out.println("POST");
//		repo.insert(user);
//		return new ResponseEntity<>(user, HttpStatus.CREATED);
//	}

}