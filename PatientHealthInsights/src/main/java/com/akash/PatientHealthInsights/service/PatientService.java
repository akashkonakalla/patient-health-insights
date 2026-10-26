package com.akash.PatientHealthInsights.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akash.PatientHealthInsights.model.Patient;
import com.akash.PatientHealthInsights.repository.PatientRepository;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Integer id) {
        return patientRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Patient not found: " + id));
    }

    public Patient addPatient(Patient patient) {
        patient.setId(null);
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Integer id, Patient patient) {
        Patient existing = getPatientById(id);

        existing.setName(patient.getName());
        existing.setAge(patient.getAge());
        existing.setDisease(patient.getDisease());

        return patientRepository.save(existing);
    }

    public void deletePatient(Integer id) {
        Patient existing = getPatientById(id);
        patientRepository.delete(existing);
    }
}
