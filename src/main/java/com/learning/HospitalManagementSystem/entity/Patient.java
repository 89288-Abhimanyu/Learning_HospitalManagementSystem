package com.learning.HospitalManagementSystem.entity;

import com.learning.HospitalManagementSystem.entity.type.BloodGroupType;
import com.learning.HospitalManagementSystem.entity.type.GenderType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table
        (name="patient", uniqueConstraints = {@UniqueConstraint(name="unique_patient_name_birthdate", columnNames = {"name", "birthDate"})},
        indexes = {@Index(name="idx_patient_birthdate", columnList = "birthDate")})
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name", nullable = false, length = 40)
    private String name;

    private LocalDate birthDate;

    private String email;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="patient_insurance_id")  //owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", cascade= CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Appointment> appointments;


}
