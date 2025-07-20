package com.example.jobseeker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobseeker.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	 Optional<User> findByEmail(String email);

}
