package com.akash.patienthealthinsights.model;

import java.time.Instant;
import java.time.LocalDate;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "follow_ups")
@Getter
@Setter
public class FollowUp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer id;

	@NotNull(message = "Patient is required")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;

	@NotNull(message = "Follow-up date is required")
	@Column(name = "follow_up_date", nullable = false)
	private LocalDate followUpDate;

	@NotNull(message = "Follow-up status is required")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private FollowUpStatus status = FollowUpStatus.PENDING;

	@Size(max = 500, message = "Notes cannot exceed 500 characters")
	@Column(length = 500)
	private String notes;

	@Column(nullable = false, updatable = false)
	@Setter(AccessLevel.NONE)
	private Instant createdAt;

	@PrePersist
	public void initializeFields() {
		if (status == null) {
			status = FollowUpStatus.PENDING;
		}

		if (createdAt == null) {
			createdAt = Instant.now();
		}
	}
}