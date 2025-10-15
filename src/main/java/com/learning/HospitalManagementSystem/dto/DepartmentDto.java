package com.learning.HospitalManagementSystem.dto;

import com.learning.HospitalManagementSystem.entity.Doctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Long id;
    private String name;
    private Doctor headDoctor;
    private Set<Doctor> doctors = new HashSet<>();

}
