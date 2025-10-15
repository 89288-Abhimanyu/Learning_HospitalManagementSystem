package com.learning.HospitalManagementSystem.service;

import com.learning.HospitalManagementSystem.dto.AddPatientRequestDto;
import com.learning.HospitalManagementSystem.dto.PatientDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PatientService {

    Page<PatientDto> getAllPatients();

    PatientDto addNewPatient(AddPatientRequestDto addPatientRequestDto);

    PatientDto getPatientById(Long id);

    void deletePatientById(Long id);

    //PatientDto updatePatient(Long Id, AddPatientRequestDto addPatientRequestDto);
}
