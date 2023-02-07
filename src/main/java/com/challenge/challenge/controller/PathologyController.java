package com.challenge.challenge.controller;

import com.challenge.challenge.api.PathologyApi;
import com.challenge.challenge.domain.Pathology;
import com.challenge.challenge.dto.request.PathologyRequest;
import com.challenge.challenge.dto.response.PathologyResponse;
import com.challenge.challenge.service.PathologyService;
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
@RequestMapping(value = "/v1/pathologies", produces = APPLICATION_JSON_VALUE)
public class PathologyController implements PathologyApi {
    private final ConversionService conversionService;

    private final PathologyService service;

    @GetMapping
    @Override
    public ResponseEntity<PathologyResponse> getAll() {
        PathologyResponse response = this.conversionService.convert(service.getAll(), PathologyResponse.class);
        return new ResponseEntity<>(response, OK);
    }

    @Override
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PathologyResponse> create(@RequestBody PathologyRequest request) {
        Pathology pathology = service.create(conversionService.convert(request, Pathology.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(conversionService.convert(pathology, PathologyResponse.class));
    }
}
