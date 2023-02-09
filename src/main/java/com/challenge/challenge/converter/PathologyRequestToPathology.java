package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Pathology;
import com.challenge.challenge.domain.Speciality;
import com.challenge.challenge.domain.Symptom;
import com.challenge.challenge.dto.request.PathologyRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Component
public class PathologyRequestToPathology implements Converter<PathologyRequest, Pathology> {


    @Override
    public Pathology convert(PathologyRequest source) {
        return ofNullable(source)
                .map(s -> Pathology.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .speciality(ofNullable(s.getSpeciality())
                                .map(sp -> Speciality.builder()
                                        .id(sp.getId())
                                        .build())
                                .orElse(null))
                        .symptoms(getSymptoms(s)
                                .orElse(null))
                        .build())
                .orElse(null);
    }

    private static Optional<Set<Symptom>> getSymptoms(PathologyRequest s) {
        return ofNullable(s.getSymptoms())
                .map(symptom -> symptom.stream()
                        .map(sy -> Symptom.builder()
                                .id(sy.getId())
                                .build())
                        .collect(Collectors.toSet()));
    }
}
