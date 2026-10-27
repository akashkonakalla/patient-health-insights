package com.akash.patienthealthinsights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.patienthealthinsights.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
