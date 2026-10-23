package com.akash.PatientHealthInsights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.PatientHealthInsights.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
