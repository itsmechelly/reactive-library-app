package com.app.controller;

import com.app.model.dto.library.LibraryRequestDto;
import com.app.model.dto.library.LibraryResponseDto;
import com.app.provider.LibraryProvider;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@AllArgsConstructor
public class LibraryControllerImpl implements LibraryController {

    private final LibraryProvider libraryProvider;

    @Override
    public Mono<LibraryResponseDto> createLibrary(final LibraryRequestDto libraryRequestDto) {
        return libraryProvider.createLibrary(libraryRequestDto);
    }

    @Override
    public Mono<UpdateResult> updateLibrary(final String id, final LibraryRequestDto libraryRequestDto) {
        return libraryProvider.updateLibrary(id, libraryRequestDto);
    }

    @Override
    public Mono<DeleteResult> deleteLibraryById(final String id) {
        return libraryProvider.deleteLibraryById(id);
    }

    @Override
    public Mono<LibraryResponseDto> getLibraryById(final String id) {
        return libraryProvider.getLibraryById(id);
    }

    @Override
    public Flux<LibraryResponseDto> getLibraries(final String name, final List<String> scholarlyArticleIds) {
        return libraryProvider.getLibraries(name, scholarlyArticleIds);
    }
}
