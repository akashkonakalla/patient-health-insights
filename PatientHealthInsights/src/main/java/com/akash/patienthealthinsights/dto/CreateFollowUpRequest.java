package com.akash.patienthealthinsights.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateFollowUpRequest {

	@NotNull(message = "Patient ID is required")
	private Integer patientId;

	@NotNull(message = "Scheduled Date is required")
	@FutureOrPresent(message = "Scheduled date cannot be in the past")
	private LocalDate scheduledDate;

	@NotBlank(message = "Follow-up purpose is requied")
	@Size(max = 255, message = "Purpose cannot exceed 255 characters")
	private String purpose;

	private String notes;
}
