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
public class Speciality {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(updatable = false, nullable = false)
    private UUID id;
    private String name;

    @OneToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @OneToMany(mappedBy = "speciality")
    private Set<Consult> consults;
}
