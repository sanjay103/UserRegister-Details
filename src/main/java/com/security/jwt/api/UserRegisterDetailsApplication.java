package com.security.jwt.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.security.jwt.api.entity.User;
import com.security.jwt.api.repository.UserRepository;

@SpringBootApplication
public class UserRegisterDetailsApplication {
	
	@Autowired 
	private UserRepository repository;
	
	@PostConstruct
	public void initUsers() {
	
		List<User> users= Stream.of(
				new User(101,"user1","pwd","user1@gmail.com"),
				new User(102,"user2","pwd1","user2@gmail.com"),
				new User(102,"user3","pwd2","user3@gmail.com"),
				new User(102,"user4","pwd3","user4@gmail.com")
				
				).collect(Collectors.toList());
					        
		 repository.saveAll(users);
	
	}
	public static void main(String[] args) {
		SpringApplication.run(UserRegisterDetailsApplication.class, args);
	}

}
