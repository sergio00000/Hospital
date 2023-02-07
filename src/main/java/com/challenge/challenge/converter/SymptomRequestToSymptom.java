package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Pathology;
import com.challenge.challenge.domain.Symptom;
import com.challenge.challenge.dto.request.SymptomRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class SymptomRequestToSymptom implements Converter<SymptomRequest, Symptom> {

    @Override
    public Symptom convert(SymptomRequest source) {
        return ofNullable(source)
                .map(s -> Symptom.builder()
                        .id(s.getId())
                        .description(s.getDescription())
                        .pathology(Pathology.builder().id(s.getPathologyId()).build())
                        .build())
                .orElse(null);
    }
}
