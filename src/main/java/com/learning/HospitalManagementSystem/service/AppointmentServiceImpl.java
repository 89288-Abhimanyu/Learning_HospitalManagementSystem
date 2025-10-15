package com.learning.HospitalManagementSystem.service;

import com.learning.HospitalManagementSystem.dto.AppointmentDto;
import com.learning.HospitalManagementSystem.dto.CreateAppointmentRequestDto;
import com.learning.HospitalManagementSystem.entity.Appointment;
import com.learning.HospitalManagementSystem.entity.Doctor;
import com.learning.HospitalManagementSystem.entity.Patient;
import com.learning.HospitalManagementSystem.repository.AppointmentRepository;
import com.learning.HospitalManagementSystem.repository.DoctorRepository;
import com.learning.HospitalManagementSystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> appointments= appointmentRepository.findAll();
        return appointments
                .stream()
                .map(appointment-> modelMapper.map(appointment, AppointmentDto.class))
                .toList();
    }

    @Override
    public AppointmentDto getAppointmentbyId(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("appointment not found with id: "+ id));
        return modelMapper.map(appointment, AppointmentDto.class);

    }

    @Override
    public AppointmentDto createNewAppointment(CreateAppointmentRequestDto createAppointmentRequestDto, Long doctorId, Long patientId) {

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        //createAppointmentRequestDto.setPatient(patient);
        //createAppointmentRequestDto.setDoctor(doctor);
        Appointment newAppointment = modelMapper.map(createAppointmentRequestDto, Appointment.class);
        newAppointment.setPatient(patient);
        newAppointment.setDoctor(doctor);
        Appointment appointment = appointmentRepository.save(newAppointment);
        return modelMapper.map(appointment, AppointmentDto.class);
    }

    @Override
    public void deleteAppointmentbyId(Long id) {
        if(!appointmentRepository.existsById(id)) {
            throw new IllegalArgumentException("appointment with this id does not exist");
        }
        appointmentRepository.deleteById(id);
    }

    @Override
    public AppointmentDto rescheduleAppointment(Long id, LocalDateTime appointmentTime) {
        Appointment appointment= appointmentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("appointment with the id does not exist"));
                appointment.setAppointmentTime(appointmentTime);
                return modelMapper.map(appointment, AppointmentDto.class);

    }


}












