package com.app.provider;

import com.app.model.dto.library.LibraryRequestDto;
import com.app.model.dto.library.LibraryResponseDto;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface LibraryProvider {

    Mono<LibraryResponseDto> createLibrary(LibraryRequestDto libraryRequestDto);

    Mono<UpdateResult> updateLibrary(String id, LibraryRequestDto libraryRequestDto);

    Mono<DeleteResult> deleteLibraryById(String id);

    Mono<LibraryResponseDto> getLibraryById(String id);

    Flux<LibraryResponseDto> getLibraries(String name, List<String> scholarlyArticleIds);
}
