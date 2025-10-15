package com.learning.HospitalManagementSystem.service;

import com.learning.HospitalManagementSystem.dto.CreateInsuranceRequestDto;
import com.learning.HospitalManagementSystem.dto.InsuranceDto;
import jakarta.validation.Valid;

import java.util.List;

public interface InsuranceService {


    List<InsuranceDto> getAllInsurance();
    InsuranceDto getInsuranceById( Long id);

    void deleteInsuranceById(Long id);

    InsuranceDto createNewInsurance(@Valid CreateInsuranceRequestDto createInsuranceRequestDto);
}
