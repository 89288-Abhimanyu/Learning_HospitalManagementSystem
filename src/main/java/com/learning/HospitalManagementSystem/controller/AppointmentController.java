package com.learning.HospitalManagementSystem.controller;

import com.learning.HospitalManagementSystem.dto.AppointmentDto;
import com.learning.HospitalManagementSystem.dto.CreateAppointmentRequestDto;
import com.learning.HospitalManagementSystem.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/{id")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentbyId(id));
    }


    @PostMapping
    public ResponseEntity<AppointmentDto> createNewAppointment(@RequestBody CreateAppointmentRequestDto createAppointmentRequestDto, Long doctorId, Long patientId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createNewAppointment(createAppointmentRequestDto, doctorId, patientId));
    }

    @DeleteMapping("/{id")
    public ResponseEntity<AppointmentDto> deleteAppointmentById(@PathVariable Long id) {
        appointmentService.deleteAppointmentbyId(id);
        return ResponseEntity.noContent().build();

    }

     @PatchMapping("/{id}")
     public ResponseEntity<AppointmentDto> rescheduleAppointment(@PathVariable Long id,
                                                                 @RequestBody LocalDateTime appointmentTime)  {
         return ResponseEntity.ok(appointmentService.rescheduleAppointment(id, appointmentTime));
     }

}


















