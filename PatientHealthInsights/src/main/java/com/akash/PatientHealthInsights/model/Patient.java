package com.akash.PatientHealthInsights.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Patient name is required")
	@Column(nullable = false)
	private String name;

	@NotBlank(message = "Age is required")
	@Column(nullable = false)
	@Min(value = 1, message = "Age must be at least 1")
	@Max(value = 150, message = "Age cannot exceed 150")
	private Integer age;

	@NotBlank(message = "Disease or condition is required")
	@Column(nullable = false)
	private String disease;

	@Column(nullable = false, updatable = false)
	private LocalDate registrationDate;

}
