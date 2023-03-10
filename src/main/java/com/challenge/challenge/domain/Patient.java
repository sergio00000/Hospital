package com.challenge.challenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "patient")
    private Set<Consult> consults;

    @ManyToMany
    @JoinTable(
            name = "patients_pathology",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "pathology_id"))
    private List<Pathology> pathologies;
}
