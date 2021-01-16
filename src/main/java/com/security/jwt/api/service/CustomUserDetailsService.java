package com.security.jwt.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.jwt.api.entity.User;
import com.security.jwt.api.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  
	 @Autowired
	    private UserRepository repository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = repository.findByUserName(username);
	        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
	
	
	    }
}

