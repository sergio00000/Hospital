package com.challenge.challenge.dto.request;

import com.challenge.challenge.domain.Doctor;
import com.challenge.challenge.domain.Patient;
import com.challenge.challenge.domain.Speciality;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultRequest {

    private UUID id;
    private Doctor doctor;
    private Speciality speciality;
    private Patient patient;
}
