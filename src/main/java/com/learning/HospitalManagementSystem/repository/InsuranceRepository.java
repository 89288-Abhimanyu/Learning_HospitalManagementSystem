package com.learning.HospitalManagementSystem.repository;

import com.learning.HospitalManagementSystem.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}