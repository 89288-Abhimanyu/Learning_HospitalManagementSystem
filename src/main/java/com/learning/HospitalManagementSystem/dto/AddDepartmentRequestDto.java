package com.learning.HospitalManagementSystem.dto;

import com.learning.HospitalManagementSystem.entity.Doctor;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class AddDepartmentRequestDto {

    private String name;

}
