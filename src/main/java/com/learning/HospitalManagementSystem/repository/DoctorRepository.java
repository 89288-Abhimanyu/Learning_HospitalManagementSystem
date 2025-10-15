package com.learning.HospitalManagementSystem.repository;

import com.learning.HospitalManagementSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}