package com.akash.PatientHealthInsights.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.PatientHealthInsights.model.Patient;
import com.akash.PatientHealthInsights.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient addPatient(Patient patient) {
		patient.setId(null);
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(Integer id) {
		return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found: " + id));
	}

	@Override
	public Patient updatePatient(Integer id, Patient patient) {

		Patient existing = getPatientById(id);

		existing.setName(patient.getName());
		existing.setAge(patient.getAge());
		existing.setDisease(patient.getDisease());

		return patientRepository.save(existing);
	}

	@Override
	public void deletePatient(Integer id) {

		Patient existing = getPatientById(id);

		patientRepository.delete(existing);
	}
}