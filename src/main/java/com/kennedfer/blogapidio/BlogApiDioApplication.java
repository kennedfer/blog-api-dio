package com.kennedfer.blogapidio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BlogApiDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApiDioApplication.class, args);
	}

}
