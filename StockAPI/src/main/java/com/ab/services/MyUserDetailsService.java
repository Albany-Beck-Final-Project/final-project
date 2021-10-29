package com.ab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ab.entities.MyUserDetails;
import com.ab.entities.User;
import com.ab.repositories.SessionRepository;
import com.ab.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private SessionRepository sessionRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<User> user = userRepo.getByEmail(userName);
		System.out.println("MyUserDetails service");
//		user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
//		return user.map(MyUserDetails::new).get();
		return new MyUserDetails(user.get());
	}
	

	
}
