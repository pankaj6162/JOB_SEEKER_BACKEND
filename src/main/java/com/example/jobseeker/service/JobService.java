package com.example.jobseeker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobseeker.repository.JobRepository;

@Service
public class JobService {
	@Autowired
	private JobRepository  jobRepository;
	
	//public String postJobService()

}
