package com.learning.HospitalManagementSystem.service;

import com.learning.HospitalManagementSystem.dto.AddDoctorRequestDto;
import com.learning.HospitalManagementSystem.dto.DoctorDto;
import com.learning.HospitalManagementSystem.dto.PatientDto;
import com.learning.HospitalManagementSystem.entity.Doctor;
import com.learning.HospitalManagementSystem.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors= doctorRepository.findAll();
        List<DoctorDto> doctorDtoList = doctors
                .stream()
                .map(doctor -> new DoctorDto(doctor.getId(), doctor.getName(), doctor.getSpecialization(), doctor.getEmail()))
                .toList();
        return doctorDtoList;
    }

    @Override
    public DoctorDto getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()->new IllegalArgumentException("doctor not found with id" +id));
        return modelMapper.map(doctor, DoctorDto.class);
    }

    @Override
    public DoctorDto addNewDoctor(AddDoctorRequestDto addDoctorRequestDto) {
        Doctor newDoctor = modelMapper.map(addDoctorRequestDto, Doctor.class);
        Doctor doctor= doctorRepository.save(newDoctor);
        return modelMapper.map(doctor, DoctorDto.class);
    }

    @Override
    public void deleteDoctorById(Long id) {
        if(!doctorRepository.existsById(id)) {
            throw new IllegalArgumentException("doctor not exists by id"+ id);
        }
        doctorRepository.deleteById(id);
    }


}
