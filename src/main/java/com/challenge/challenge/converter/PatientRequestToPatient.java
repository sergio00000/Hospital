package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Pathology;
import com.challenge.challenge.domain.Patient;
import com.challenge.challenge.dto.request.PatientRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Optional.ofNullable;

@Component
public class PatientRequestToPatient implements Converter<PatientRequest, Patient> {
    @Override
    public Patient convert(PatientRequest source) {
        return ofNullable(source)
                .map(s -> Patient.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .dateOfBirth(s.getDateOfBirth())
                        .pathologies(ofNullable(s.getPathologies())
                                .map(p -> {
                                    List<Pathology> pathologies = new ArrayList<>();
                                    for (UUID pathologyId: p) {
                                        pathologies.add(Pathology.builder().id(pathologyId).build());
                                    }
                                    return pathologies;
                                }).orElse(null))
                        .build())
                .orElse(null);
    }
}
