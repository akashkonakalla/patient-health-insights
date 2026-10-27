package com.akash.PatientHealthInsights.service;

import java.util.List;

import com.akash.PatientHealthInsights.model.Patient;

public interface PatientService {

	Patient addPatient(Patient patient);

	List<Patient> getAllPatients();

	Patient getPatientById(Integer id);

	Patient updatePatient(Integer id, Patient patient);

	void deletePatient(Integer id);

}