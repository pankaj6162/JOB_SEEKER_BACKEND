package com.example.jobseeker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobseeker.entity.User;
import com.example.jobseeker.repository.UserRepository;
import com.example.jobseeker.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserAuthController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passEncoder;
	
	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		user.setPassword(passEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return ResponseEntity.ok("User Register Succefully!");
	
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String email,@RequestParam String password){
		Optional<User> user=userRepository.findByEmail(email);
		if(user.isPresent() && passEncoder.matches(password, user.get().getPassword())) {
			return ResponseEntity.ok("Login Successful!");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials!");
	}

}
