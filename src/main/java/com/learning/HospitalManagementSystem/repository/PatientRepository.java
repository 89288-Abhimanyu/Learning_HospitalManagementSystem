package com.learning.HospitalManagementSystem.repository;

import com.learning.HospitalManagementSystem.dto.PatientDto;
import com.learning.HospitalManagementSystem.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value="SELECT * FROM patient", nativeQuery = true)
    Page<Patient> findAllPatientsByPagenation(Pageable pageable);
}