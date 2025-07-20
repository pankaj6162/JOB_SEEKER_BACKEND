package com.example.jobseeker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobseeker.entity.JobApplication;
import com.example.jobseeker.entity.User;


public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
	
	List<JobApplication>findByJobSeeker(User user);

}
