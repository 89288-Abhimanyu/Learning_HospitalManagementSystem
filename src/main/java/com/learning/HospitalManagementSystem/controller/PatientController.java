package com.learning.HospitalManagementSystem.controller;

import com.learning.HospitalManagementSystem.dto.AddPatientRequestDto;
import com.learning.HospitalManagementSystem.dto.PatientDto;
import com.learning.HospitalManagementSystem.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity <Page<PatientDto>> getAllPatients() {
        return  ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }


    @PostMapping("/patients")
    public ResponseEntity<PatientDto> addNewPatient(@RequestBody@Valid AddPatientRequestDto addPatientRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.addNewPatient(addPatientRequestDto));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAPatient(@PathVariable Long id) {
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }



}
