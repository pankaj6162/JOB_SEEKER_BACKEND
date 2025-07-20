package com.example.jobseeker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobseeker.entity.Job;
import com.example.jobseeker.entity.JobApplication;
import com.example.jobseeker.entity.User;
import com.example.jobseeker.repository.JobApplicationRepository;
import com.example.jobseeker.repository.JobRepository;

@RestController
@RequestMapping("/api/jobseeker")
public class JobSeekerController {
	private JobApplicationRepository jobApplicationRepository;
	private JobRepository jobRepository;
	
	@PostMapping("apply/{jobId}")
	public ResponseEntity<String> applyForJob(@PathVariable Integer jobId, Authentication authentication){
		User jobSeeker=(User)authentication.getPrincipal();
		JobApplication application=new JobApplication();
		application.setJobSeeker(jobSeeker);
		application.setJob(jobRepository.findById(jobId).get());
		jobApplicationRepository.save(application);
		return ResponseEntity.ok("Application Submitted successfully1");
		
	}

}
