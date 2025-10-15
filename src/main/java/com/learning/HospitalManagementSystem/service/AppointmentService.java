package com.learning.HospitalManagementSystem.service;

import com.learning.HospitalManagementSystem.dto.AppointmentDto;
import com.learning.HospitalManagementSystem.dto.CreateAppointmentRequestDto;
import com.learning.HospitalManagementSystem.entity.Appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface AppointmentService {
    public AppointmentDto createNewAppointment(CreateAppointmentRequestDto createAppointmentRequestDto, Long doctorId, Long patientId);

    List<AppointmentDto> getAllAppointments();

    AppointmentDto getAppointmentbyId(Long id);

    void deleteAppointmentbyId(Long id);

    AppointmentDto rescheduleAppointment(Long id, LocalDateTime appointmentTime);
}
