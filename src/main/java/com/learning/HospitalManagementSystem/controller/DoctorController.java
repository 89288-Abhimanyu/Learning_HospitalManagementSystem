package com.learning.HospitalManagementSystem.controller;

import com.learning.HospitalManagementSystem.dto.DoctorDto;
import com.learning.HospitalManagementSystem.dto.AddDoctorRequestDto;
import com.learning.HospitalManagementSystem.dto.PatientDto;
import com.learning.HospitalManagementSystem.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorDto> addNewDoctor(@RequestBody @Valid AddDoctorRequestDto addDoctorRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.addNewDoctor(addDoctorRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteADoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
        return ResponseEntity.noContent().build();
    }


}
