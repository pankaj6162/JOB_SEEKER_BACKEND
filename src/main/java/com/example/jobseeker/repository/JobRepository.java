package com.example.jobseeker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobseeker.entity.Job;
import com.example.jobseeker.entity.User;

public interface JobRepository extends JpaRepository<Job, Integer> {
	
	List<Job> findByEmployer(User user);

}
