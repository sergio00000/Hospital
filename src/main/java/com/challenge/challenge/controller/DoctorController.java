package com.challenge.challenge.controller;

import com.challenge.challenge.api.DoctorApi;
import com.challenge.challenge.domain.Doctor;
import com.challenge.challenge.dto.request.DoctorRequest;
import com.challenge.challenge.dto.response.DoctorResponse;
import com.challenge.challenge.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/doctors", produces = APPLICATION_JSON_VALUE)
public class DoctorController implements DoctorApi {

    private final DoctorService service;
    private final ConversionService conversionService;

    @GetMapping("/doctors/{id}")
    @Override
    public ResponseEntity<DoctorResponse> getDoctorById(@PathVariable UUID id) {
        DoctorResponse response = this.conversionService.convert(service.getDoctorById(id), DoctorResponse.class);
        return new ResponseEntity<>(response, OK);
    }

    @Override
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DoctorResponse> create(@RequestBody DoctorRequest request) {
        Doctor doctor = service.create(conversionService.convert(request, Doctor.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(conversionService.convert(doctor, DoctorResponse.class));
    }

}

