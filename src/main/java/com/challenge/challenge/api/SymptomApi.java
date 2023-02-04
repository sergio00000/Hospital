package com.challenge.challenge.api;

import com.challenge.challenge.dto.request.SymptomRequest;
import com.challenge.challenge.dto.response.SymptomResponse;
import com.challenge.challenge.utils.OpenApi3Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Api Symptoms", description = "Api for details Symptoms")
public interface SymptomApi {

    @Operation(description = "Get all symptoms",
            tags = "Symptom",
            method = OpenApi3Constants.GET)
    @ApiResponse(responseCode = "200", description = OpenApi3Constants.MSG_STATUS_200)
    ResponseEntity<SymptomResponse> getAll();
    
    @Operation(summary = "Create symptom in the database", description = "Create symptom in the database",
            tags = "Symptom", method = OpenApi3Constants.POST)
    @ApiResponse(responseCode = "201", description = OpenApi3Constants.MSG_STATUS_201)
    ResponseEntity<SymptomResponse> create(SymptomRequest symptomRequest);
}
