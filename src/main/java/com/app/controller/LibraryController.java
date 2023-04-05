package com.app.controller;

import com.app.core.exception.AppErrorResponse;
import com.app.model.dto.library.LibraryRequestDto;
import com.app.model.dto.library.LibraryResponseDto;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.lang.Nullable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@Tag(name = "Library Controller", description = "Library Controller")
@RequestMapping(path = "/api/v1/library", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.ALL_VALUE})
public interface LibraryController {

    @PostMapping()
    @Operation(summary = "create library")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create library response"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = AppErrorResponse.class)))})
    Mono<LibraryResponseDto> createLibrary(@RequestBody @Valid LibraryRequestDto libraryRequestDto);

    @PutMapping("{id}")
    @Operation(summary = "update library")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update library response"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = AppErrorResponse.class)))})
    Mono<UpdateResult> updateLibrary(@PathVariable(value = "id") String id, @RequestBody @Valid LibraryRequestDto libraryRequestDto);

    @DeleteMapping("{id}")
    @Operation(summary = "delete library by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete library response"),
            @ApiResponse(responseCode = "204", description = "No matching data", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = AppErrorResponse.class)))})
    Mono<DeleteResult> deleteLibraryById(@PathVariable(value = "id") String id);

    @GetMapping("{id}")
    @Operation(summary = "get library by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get library by id response"),
            @ApiResponse(responseCode = "204", description = "No matching data", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = AppErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "NOt Found", content = @Content(schema = @Schema(implementation = AppErrorResponse.class)))})
    Mono<LibraryResponseDto> getLibraryById(@PathVariable(value = "id") String id);

    @GetMapping()
    @Operation(summary = "get libraries")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get libraries"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = AppErrorResponse.class)))})
    Flux<LibraryResponseDto> getLibraries(@RequestParam(value = "name") @Nullable String name, @RequestParam(value = "scholarlyArticleIds") @Nullable List<String> scholarlyArticleIds);
}
