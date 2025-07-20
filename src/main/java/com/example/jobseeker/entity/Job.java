package com.example.jobseeker.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="post_jobs")
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Job {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String jobTitle;
	private String jobDescription;
	private double salary;
	private String location;
	private String companyName;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private User employer;
	

}
