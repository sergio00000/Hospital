package com.challenge.challenge.controller;

import com.challenge.challenge.api.PatientApi;
import com.challenge.challenge.domain.Patient;
import com.challenge.challenge.dto.request.PatientRequest;
import com.challenge.challenge.dto.response.PatientConsultRootResponse;
import com.challenge.challenge.dto.response.PatientResponse;
import com.challenge.challenge.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/patients", produces = APPLICATION_JSON_VALUE)
public class PatientController implements PatientApi {
    private final ConversionService conversionService;

    private final PatientService service;

    @Override
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PatientResponse> create(@RequestBody PatientRequest request) {
        Patient patient = service.create(conversionService.convert(request, Patient.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(conversionService.convert(patient, PatientResponse.class));
    }

    @Override
    @GetMapping("/{id}/consults")
    public ResponseEntity<Collection<PatientConsultRootResponse>> getPatientConsult(@PathVariable UUID id){
        Patient patient = service.getPatientById(id);
        PatientConsultRootResponse patientResponse = conversionService.convert(patient, PatientConsultRootResponse.class);
        Collection<PatientConsultRootResponse> response = Collections.singletonList(patientResponse);
        return ResponseEntity.ok(response);
    }
}
