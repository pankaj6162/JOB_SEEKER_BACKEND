package com.example.jobseeker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobseeker.entity.Job;
import com.example.jobseeker.entity.User;
import com.example.jobseeker.repository.JobRepository;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {
	@Autowired
	private JobRepository jobRepository;
	
	@PostMapping("/post-job")
	public ResponseEntity<Job> postJob(@RequestBody Job job, Authentication authentication){
		User employer=(User)authentication.getPrincipal();
		job.setEmployer(employer);
		return ResponseEntity.ok(jobRepository.save(job));
	}

}
