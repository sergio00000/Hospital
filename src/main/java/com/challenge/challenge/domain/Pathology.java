package com.challenge.challenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Pathology {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name="speciality_id")
    private Speciality speciality;

    @ManyToMany
    @JoinTable(
            name = "patientsPathology",
            joinColumns = @JoinColumn(name = "pathology_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private Set<Patient> pathologyPatients;

    @OneToMany(mappedBy = "pathology")
    private Set<Symptom> symptoms;

}
