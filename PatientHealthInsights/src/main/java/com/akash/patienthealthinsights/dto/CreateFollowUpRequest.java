package com.akash.patienthealthinsights.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFollowUpRequest {

	@NotNull(message = "Patient ID is required")
	private Integer patientId;

	@NotNull(message = "Follow-up date is required")
	@FutureOrPresent(message = "Follow-up date cannot be in the past")
	private LocalDate followUpDate;

	private String notes;
}
