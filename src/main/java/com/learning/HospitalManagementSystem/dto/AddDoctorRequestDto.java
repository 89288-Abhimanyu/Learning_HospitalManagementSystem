package com.learning.HospitalManagementSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddDoctorRequestDto {

    @Size(min = 3, max = 30, message = "name should be of 3 to 30 characters")
    private String name;

    private String specialization;

    @Email
    private String  email;
}
