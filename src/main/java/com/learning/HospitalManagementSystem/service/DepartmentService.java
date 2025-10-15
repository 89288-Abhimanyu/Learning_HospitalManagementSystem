package com.learning.HospitalManagementSystem.service;

import com.learning.HospitalManagementSystem.dto.AddDepartmentRequestDto;
import com.learning.HospitalManagementSystem.dto.DepartmentDto;
import com.learning.HospitalManagementSystem.entity.Doctor;

import java.util.List;
import java.util.Set;

public interface DepartmentService {
    List<DepartmentDto> getAllDepartments();

    DepartmentDto getDepartmentById(Long id);

    DepartmentDto addNewDepartment(AddDepartmentRequestDto addDepartmentRequestDto, Long headDoctorId);

    DepartmentDto addDoctorsToDepartment(Long id, Long doctorId);
}
