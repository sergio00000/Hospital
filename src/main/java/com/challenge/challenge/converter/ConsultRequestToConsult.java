package com.challenge.challenge.converter;

import com.challenge.challenge.domain.Consult;
import com.challenge.challenge.domain.Doctor;
import com.challenge.challenge.domain.Patient;
import com.challenge.challenge.domain.Speciality;
import com.challenge.challenge.dto.request.ConsultRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
public class ConsultRequestToConsult implements Converter<ConsultRequest, Consult> {
    @Override
    public Consult convert(ConsultRequest source) {
        return ofNullable(source)
                .map(s -> Consult.builder()
                        .id(s.getId())
                        .patient(Patient.builder()
                                .id(ofNullable(s.getPatient())
                                        .map(Patient::getId)
                                        .orElse(null))
                                .build())
                        .doctor(Doctor.builder()
                                .id(ofNullable(s.getDoctor())
                                        .map(Doctor::getId)
                                        .orElse(null))
                                .build())
                        .speciality(Speciality.builder()
                                .id(ofNullable(s.getSpeciality())
                                        .map(Speciality::getId)
                                        .orElse(null))
                                .build())
                        .build())
                .orElse(null);
    }
}
