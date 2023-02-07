package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Pathology;
import com.challenge.challenge.domain.Speciality;
import com.challenge.challenge.dto.request.PathologyRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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
                        .build())
                .orElse(null);
    }
}
