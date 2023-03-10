package com.challenge.challenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Consult {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="speciality_id")
    private Speciality speciality;
}
