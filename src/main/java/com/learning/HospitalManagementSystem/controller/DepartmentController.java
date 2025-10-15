package com.learning.HospitalManagementSystem.controller;

import com.learning.HospitalManagementSystem.dto.AddDepartmentRequestDto;
import com.learning.HospitalManagementSystem.dto.AppointmentDto;
import com.learning.HospitalManagementSystem.dto.CreateAppointmentRequestDto;
import com.learning.HospitalManagementSystem.dto.DepartmentDto;
import com.learning.HospitalManagementSystem.entity.Department;
import com.learning.HospitalManagementSystem.entity.Doctor;
import com.learning.HospitalManagementSystem.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/{departments}")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> addNewDepartment(@RequestBody AddDepartmentRequestDto addDepartmentRequestDto, Long headDoctorId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addNewDepartment(addDepartmentRequestDto, headDoctorId));
    }

    @PatchMapping("/{id}/{doctorId}")
    public ResponseEntity<DepartmentDto> addDoctorsToDepartment(@PathVariable Long id,
                                                    @PathVariable Long doctorId) {
        return ResponseEntity.ok(departmentService.addDoctorsToDepartment(id, doctorId));
    }
}
