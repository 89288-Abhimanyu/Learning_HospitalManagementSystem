package com.learning.HospitalManagementSystem.service;

import com.learning.HospitalManagementSystem.dto.AddDoctorRequestDto;
import com.learning.HospitalManagementSystem.dto.DoctorDto;
import com.learning.HospitalManagementSystem.dto.PatientDto;
import jakarta.validation.Valid;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> getAllDoctors();

    DoctorDto getDoctorById(Long id);

    DoctorDto addNewDoctor(@Valid AddDoctorRequestDto addDoctorRequestDto);

    void deleteDoctorById(Long id);
}
