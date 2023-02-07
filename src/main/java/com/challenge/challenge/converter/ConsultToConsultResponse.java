package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Consult;
import com.challenge.challenge.dto.response.ConsultResponse;
import com.challenge.challenge.dto.response.DoctorResponse;
import com.challenge.challenge.dto.response.PatientResponse;
import com.challenge.challenge.dto.response.SpecialityResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class ConsultToConsultResponse implements Converter<Consult, ConsultResponse> {
    @Override
    public ConsultResponse convert(Consult source) {
        return ofNullable(source)
                .map(s -> ConsultResponse.builder()
                        .id(s.getId())
                        .doctor(ofNullable(s.getDoctor())
                                .map(d -> DoctorResponse.builder()
                                        .id(d.getId())
                                        .build())
                                .orElse(null))
                        .speciality(ofNullable(s.getSpeciality())
                                .map(sp -> SpecialityResponse.builder()
                                        .id(sp.getId())
                                        .build())
                                .orElse(null))
                        .patient(ofNullable(s.getPatient())
                                .map(p -> PatientResponse.builder()
                                        .id(p.getId())
                                        .build())
                                .orElse(null))
                        .build())
                .orElse(null);
    }
}
