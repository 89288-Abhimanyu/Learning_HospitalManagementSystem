package com.learning.HospitalManagementSystem.dto;

import com.learning.HospitalManagementSystem.entity.Appointment;
import com.learning.HospitalManagementSystem.entity.Insurance;
import com.learning.HospitalManagementSystem.entity.type.BloodGroupType;
import com.learning.HospitalManagementSystem.entity.type.GenderType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AddPatientRequestDto {

    //@NotBlank(message = "name field can't be left blank")
    @Size(min =3, max=30, message="name should be of 3 to 30 characters)")
    private String name;

    //@NotBlank(message = "birthDate field can't be left blank")
    private LocalDate birthDate;

    private String email;

    //@NotBlank(message = "gender field can't be left blank")
    private GenderType gender;

    private BloodGroupType bloodGroup;

    //private Insurance insurance;

    //private Appointment appointment;



}
