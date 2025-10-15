package com.learning.HospitalManagementSystem.dto;

import com.learning.HospitalManagementSystem.entity.Doctor;
import com.learning.HospitalManagementSystem.entity.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
public class CreateAppointmentRequestDto {

    private LocalDateTime appointmentTime;
    private String reason;
    private Patient patient;
    private Doctor doctor;
}
