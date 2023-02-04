package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Symptom;
import com.challenge.challenge.dto.response.PathologyResponse;
import com.challenge.challenge.dto.response.SymptomResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class SymptomToSymptomResponse implements Converter<Symptom, SymptomResponse> {
    @Override
    public SymptomResponse convert(Symptom source) {
        return ofNullable(source)
                .map(s -> SymptomResponse.builder()
                        .id(s.getId())
                        .description(s.getDescription())
                        .pathology(ofNullable(s.getPathology())
                                .map(p -> PathologyResponse.builder()
                                        .id(p.getId())
                                        .name(p.getName())
                                        .build())
                                .orElse(null))
                        .build())
                .orElse(null);
    }
}
