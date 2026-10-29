package com.akash.patienthealthinsights.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.patienthealthinsights.model.Patient;
import com.akash.patienthealthinsights.service.PatientService;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "http://localhost:5173")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable Integer id) {
		return patientService.getPatientById(id);
	}

}
