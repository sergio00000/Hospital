package com.challenge.challenge.api;

import com.challenge.challenge.dto.request.PathologyRequest;
import com.challenge.challenge.dto.response.PathologyResponse;
import com.challenge.challenge.utils.OpenApi3Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Api Pathologies", description = "Api for details Pathologies")
public interface PathologyApi {

    @Operation(description = "Get all pathologies",
            tags = "Pathology",
            method = OpenApi3Constants.GET)
    @ApiResponse(responseCode = "200", description = OpenApi3Constants.MSG_STATUS_200)
    ResponseEntity<PathologyResponse> getAll();
    
    @Operation(summary = "Create pathology in the database", description = "Create pathology in the database",
            tags = "Pathology", method = OpenApi3Constants.POST)
    @ApiResponse(responseCode = "201", description = OpenApi3Constants.MSG_STATUS_201)
    ResponseEntity<PathologyResponse> create(PathologyRequest pathologyRequest);
}
