package com.learning.HospitalManagementSystem.controller;

import com.learning.HospitalManagementSystem.dto.CreateInsuranceRequestDto;
import com.learning.HospitalManagementSystem.dto.InsuranceDto;
import com.learning.HospitalManagementSystem.service.InsuranceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/insurances")
public class InsuranceController {

    private final InsuranceService insuranceService;

    @GetMapping
    public ResponseEntity<List<InsuranceDto>> getAllInsurance() {
        return ResponseEntity.ok(insuranceService.getAllInsurance());
    }

    @GetMapping("{/id}")
    public ResponseEntity<InsuranceDto> getInsuranceById(@PathVariable Long id) {
        return ResponseEntity.ok(insuranceService.getInsuranceById(id));
    }

    @PostMapping
    public ResponseEntity<InsuranceDto> createNewInsurance(@RequestBody@Valid CreateInsuranceRequestDto createInsuranceRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(insuranceService.createNewInsurance(createInsuranceRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAInsurance(@PathVariable Long id) {
        insuranceService.deleteInsuranceById(id);
        return ResponseEntity.noContent().build();
    }

}
