package com.challenge.challenge.repository;

import com.challenge.challenge.domain.Pathology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PathologyRepository extends JpaRepository<Pathology, UUID> {
}
