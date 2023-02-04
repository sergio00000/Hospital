package com.challenge.challenge.controller;

import com.challenge.challenge.api.SymptomApi;
import com.challenge.challenge.domain.Symptom;
import com.challenge.challenge.dto.request.SymptomRequest;
import com.challenge.challenge.dto.response.SymptomResponse;
import com.challenge.challenge.service.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/symptoms", produces = APPLICATION_JSON_VALUE)
public class SymptomController implements SymptomApi {
    private final ConversionService conversionService;

    private final SymptomService service;

    @GetMapping
    @Override
    public ResponseEntity<SymptomResponse> getAll() {
        SymptomResponse response = this.conversionService.convert(service.getAll(), SymptomResponse.class);
        return new ResponseEntity<>(response, OK);
    }

    @Override
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SymptomResponse> create(@RequestBody SymptomRequest request) {
        Symptom symptom = service.create(conversionService.convert(request, Symptom.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(conversionService.convert(symptom, SymptomResponse.class));
    }
}
