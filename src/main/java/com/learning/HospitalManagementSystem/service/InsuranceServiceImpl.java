package com.learning.HospitalManagementSystem.service;

import com.learning.HospitalManagementSystem.dto.AppointmentDto;
import com.learning.HospitalManagementSystem.dto.CreateInsuranceRequestDto;
import com.learning.HospitalManagementSystem.dto.InsuranceDto;
import com.learning.HospitalManagementSystem.entity.Insurance;
import com.learning.HospitalManagementSystem.repository.InsuranceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class InsuranceServiceImpl implements InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<InsuranceDto> getAllInsurance() {
        List<Insurance> insurances = insuranceRepository.findAll();
        return insurances
                .stream()
                .map(insurance-> modelMapper.map(insurance, InsuranceDto.class))
                .toList();
    }

    @Override
    public InsuranceDto getInsuranceById(Long id) {
        Insurance insurance = insuranceRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Insurance not found with id: "+ id));
        return modelMapper.map(insurance, InsuranceDto.class);
    }

    @Override
    public void deleteInsuranceById(Long id) {
        if(!insuranceRepository.existsById(id)) {
            throw new IllegalArgumentException("Insurance does not exists by id: "+ id);
        }
        insuranceRepository.deleteById(id);
    }

    @Override
    public InsuranceDto createNewInsurance(CreateInsuranceRequestDto createInsuranceRequestDto) {
        Insurance newStudent = modelMapper.map(createInsuranceRequestDto, Insurance.class);
        Insurance student=insuranceRepository.save(newStudent);
        return modelMapper.map(student, InsuranceDto.class);
        }
    }




}
