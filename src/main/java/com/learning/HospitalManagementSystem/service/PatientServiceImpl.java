package com.learning.HospitalManagementSystem.service;

import com.learning.HospitalManagementSystem.dto.AddPatientRequestDto;
import com.learning.HospitalManagementSystem.dto.PatientDto;
import com.learning.HospitalManagementSystem.entity.Patient;
import com.learning.HospitalManagementSystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<PatientDto> getAllPatients() {
        Page<Patient> patients = patientRepository.findAllPatientsByPagenation(PageRequest.of(1,3));
       // Page<PatientDto> patientDtoList= patients
         //       .stream()
           //     .map(patient-> new PatientDto(patient.getId()
             //           , patient.getName()
               //         , patient.getBirthDate()
                 //       , patient.getEmail()
                   //     , patient.getGender()
                     //   , patient.getBloodGroup()
                       // , patient.getCreatedAt()
                        //, patient.getInsurance()))
               // .toList();
        //return patientDtoList;
        return patients.map(patient ->
                new PatientDto(
                        patient.getId(),
                        patient.getName(),
                        patient.getBirthDate(),
                        patient.getEmail(),
                        patient.getGender(),
                        patient.getBloodGroup(),
                        patient.getCreatedAt(),
                        patient.getInsurance()
                )
        );
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("student not found with id: "+id));
        return modelMapper.map(patient, PatientDto.class);
    }

    @Transactional
    @Override
    public PatientDto addNewPatient(AddPatientRequestDto addPatientRequestDto) {
        Patient newPatient = modelMapper.map(addPatientRequestDto, Patient.class);
        Patient patient = patientRepository.save(newPatient);
        return modelMapper.map(patient, PatientDto.class);
    }


    @Override
    public void deletePatientById(Long id) {
        if(!patientRepository.existsById(id)) {
            throw new IllegalArgumentException("Patient with this id does not exist"+ id);
        }
        patientRepository.deleteById(id);
    }




}




