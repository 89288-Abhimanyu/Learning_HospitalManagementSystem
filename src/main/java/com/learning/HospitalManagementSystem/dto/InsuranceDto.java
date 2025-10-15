package com.learning.HospitalManagementSystem.dto;

import com.learning.HospitalManagementSystem.entity.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDto {

    private Long id;
    private String policyNumber;
    private String provider;
    private LocalDate validUntil;
    private LocalDateTime createdAt;
    private Patient patient;

}
