package com.learning.HospitalManagementSystem.dto;

import com.learning.HospitalManagementSystem.entity.Doctor;
import com.learning.HospitalManagementSystem.entity.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private Patient patient;
    private Doctor doctor;
}
