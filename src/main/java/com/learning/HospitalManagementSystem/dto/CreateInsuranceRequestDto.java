package com.learning.HospitalManagementSystem.dto;

import com.learning.HospitalManagementSystem.entity.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreateInsuranceRequestDto {

    @NotBlank(message = "field can't be left blank")
    private String policyNumber;

    @NotBlank(message = "field can't be left blank")
    private String provider;

    @NotBlank(message = "field can't be left blank")
    private LocalDate validUntil;

}
