package com.learning.HospitalManagementSystem.service;

import com.learning.HospitalManagementSystem.dto.AddDepartmentRequestDto;
import com.learning.HospitalManagementSystem.dto.AppointmentDto;
import com.learning.HospitalManagementSystem.dto.DepartmentDto;
import com.learning.HospitalManagementSystem.entity.Appointment;
import com.learning.HospitalManagementSystem.entity.Department;
import com.learning.HospitalManagementSystem.entity.Doctor;
import com.learning.HospitalManagementSystem.entity.Patient;
import com.learning.HospitalManagementSystem.repository.DepartmentRepository;
import com.learning.HospitalManagementSystem.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments= departmentRepository.findAll();
        return departments
                .stream()
                .map(department-> modelMapper.map(department, DepartmentDto.class))
                .toList();
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("department not found with id: "+ id));
        return modelMapper.map(department, DepartmentDto.class);
    }

    @Override
    public DepartmentDto addNewDepartment(AddDepartmentRequestDto addDepartmentRequestDto, Long headDoctorId) {
        Doctor doctor = doctorRepository.findById(headDoctorId).orElseThrow();;
        //addDepartmentRequestDto.setDoctor(doctor);
        Department newDepartment = modelMapper.map(addDepartmentRequestDto, Department.class);
        newDepartment.setHeadDoctor(doctor);
        Department department = departmentRepository.save(newDepartment);
        return modelMapper.map(department, DepartmentDto.class);

    }

    @Override
    public DepartmentDto addDoctorsToDepartment(Long id, Long doctorId) {
        Department department= departmentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("department not found with given id" + id));
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("doctor not found with given id" + id));
        department.getDoctors().add(doctor);
        departmentRepository.save(department);
        return modelMapper.map(department, DepartmentDto.class);

    }
}
