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
@Table(name="applications")
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class JobApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String resumePath;
	private String status="Pending";// Pending, Accepted, Rejected
	
	@ManyToOne
	@JoinColumn(name="job_id")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private User jobSeeker;

}
