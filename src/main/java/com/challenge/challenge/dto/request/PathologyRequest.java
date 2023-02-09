package com.challenge.challenge.dto.request;

import com.challenge.challenge.domain.Speciality;
import com.challenge.challenge.domain.Symptom;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PathologyRequest {
    private UUID id;
    private String name;
    private Speciality speciality;
    private List<Symptom> symptoms;
}
