package com.blog;

import com.blog.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.naming.Context;

@SpringBootApplication
public class BlogAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppBackendApplication.class, args);

	}

}
