package com.challenge.challenge.dto.request;

import com.challenge.challenge.domain.Doctor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpecialityRequest {
    private UUID id;
    private String name;
    private Doctor doctor;
}
