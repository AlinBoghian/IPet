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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories

public class DemoApplication {
//	@Autowired
//	MyRepository repo;
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test1");
//		try {
//			EntityManager em = emf.createEntityManager();
//			nativeQuery(em, "SHOW TABLES");
//			nativeQuery(em, "SHOW COLUMNS from EntityA");
//			nativeQuery(em, "SHOW COLUMNS from EntityB");
//			emf.close();
//		} finally {
//			emf.close();
//		}
	}

//	private static void nativeQuery(EntityManager em, String s) {
//		System.out.println("--------\n" + s);
//		Query query = em.createNativeQuery(s);
//		List list = query.getResultList();
//		for (Object o : list) {
//			System.out.println(Arrays.toString((Object[]) o));
//		}
//	}



}