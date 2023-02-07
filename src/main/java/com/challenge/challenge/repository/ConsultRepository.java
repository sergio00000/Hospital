package com.challenge.challenge.repository;

import com.challenge.challenge.domain.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, UUID> {
}
