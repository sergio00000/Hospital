package com.challenge.challenge.repository;

import com.challenge.challenge.domain.Pathology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PathologyRepository extends JpaRepository<Pathology, UUID> {
}
