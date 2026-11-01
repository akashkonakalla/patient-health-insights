package com.akash.patienthealthinsights.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "follow_ups")
@Getter
@Setter
public class FollowUp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Scheduled date is required")
	@Column(nullable = false)
	private LocalDate scheduledDate;

	@NotBlank(message = "Follow-up purpose is required")
	@Column(nullable = false, length = 255)
	private String purpose;

	@Column(columnDefinition = "TEXT")
	private String notes;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private FollowUpStatus status;

	@Column
	private LocalDateTime completedAt;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;

	@PrePersist
	public void initializeFollowUp() {
		if (status == null) {
			status = FollowUpStatus.PENDING;
		}
	}
}