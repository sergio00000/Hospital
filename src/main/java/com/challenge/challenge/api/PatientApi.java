package com.challenge.challenge.api;

import com.challenge.challenge.dto.request.PatientRequest;
import com.challenge.challenge.dto.response.PatientConsultRootResponse;
import com.challenge.challenge.dto.response.PatientResponse;
import com.challenge.challenge.utils.OpenApi3Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.UUID;

@Tag(name = "Api Patient", description = "Api for details Patient")
public interface PatientApi {

    @Operation(summary = "Create patient in the database", description = "Create patient in the database",
            tags = "Patient", method = OpenApi3Constants.POST)
    @ApiResponse(responseCode = "201", description = OpenApi3Constants.MSG_STATUS_201)
    ResponseEntity<PatientResponse> create(PatientRequest patientRequest);

    @Operation(summary = "Get patient in the database", description = "get patient in the database",
            tags = "Patient", method = OpenApi3Constants.GET)
    @ApiResponse(responseCode = "200", description = OpenApi3Constants.MSG_STATUS_200)
    ResponseEntity<Collection<PatientConsultRootResponse>> getPatientConsult(@PathVariable UUID id);
}
