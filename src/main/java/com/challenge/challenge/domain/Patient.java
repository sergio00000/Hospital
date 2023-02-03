package com.challenge.challenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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

    @ManyToMany(mappedBy = "pathologyPatients")
    private Set<Pathology> pathologies;
}
