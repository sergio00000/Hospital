package com.challenge.challenge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Pathology {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name="speciality_id")
    private Speciality speciality;

    @ManyToMany
    @JoinTable(
            name = "patholy_patient",
            joinColumns = @JoinColumn(name = "pathology_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private Set<Patient> pathologyPatients;

    @ManyToMany
    @JoinTable(
            name = "patholy_symptom",
            joinColumns = @JoinColumn(name = "pathology_id"),
            inverseJoinColumns = @JoinColumn(name = "symptom_id"))
    private Set<Symptom> pathologySymptoms;

}
