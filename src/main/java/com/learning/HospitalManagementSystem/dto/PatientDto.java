package com.learning.HospitalManagementSystem.dto;

import com.learning.HospitalManagementSystem.entity.Appointment;
import com.learning.HospitalManagementSystem.entity.Insurance;
import com.learning.HospitalManagementSystem.entity.type.BloodGroupType;
import com.learning.HospitalManagementSystem.entity.type.GenderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private String email;
    private GenderType gender;
    private BloodGroupType bloodGroup;
    private LocalDateTime createdAt;
    private Insurance insurance;

}

