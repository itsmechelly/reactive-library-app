package com.app.provider;

import com.app.core.exception.NoContentException;
import com.app.core.exception.provider.ResourceNotFoundException;
import com.app.model.domain.Library;
import com.app.model.dto.library.LibraryRequestDto;
import com.app.model.dto.library.LibraryResponseDto;
import com.app.model.transformer.LibraryTransformer;
import com.app.service.LibraryService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class LibraryProviderImpl implements LibraryProvider {

    private final LibraryService libraryService;

    @Override
    public Mono<LibraryResponseDto> createLibrary(final LibraryRequestDto libraryRequestDto) {
        log.info("createLibrary() REQUEST: libraryRequestDto: {}", libraryRequestDto);
        final Library newLibrary = LibraryTransformer.libraryRequestDtoToLibrary(libraryRequestDto);
        return libraryService.createLibrary(newLibrary)
                .doOnNext(library -> log.info("createLibrary()::ON_NEXT libraryRequestDto: {}, result: library: {}", libraryRequestDto, library))
                .doOnError(throwable -> log.info("createLibrary()::ON_ERROR throwable: {}", throwable.getMessage()))
                .map(LibraryTransformer::libraryToLibraryResponseDto);
    }

    @Override
    public Mono<UpdateResult> updateLibrary(final String id, final LibraryRequestDto libraryRequestDto) {
        log.info("updateLibrary() REQUEST: libraryRequestDto: {}", libraryRequestDto);
        final Library newLibrary = LibraryTransformer.libraryRequestDtoToLibrary(libraryRequestDto);
        return libraryService.updateLibrary(id, newLibrary)
                .doOnNext(updatedLibrary -> log.info("updateLibrary()::ON_NEXT libraryRequestDto: {}, result: library: {}", libraryRequestDto, updatedLibrary))
                .doOnError(throwable -> log.info("updateLibrary()::ON_ERROR throwable: {}", throwable.getMessage()));
    }

    @Override
    public Mono<DeleteResult> deleteLibraryById(final String id) {
        log.info("deleteLibraryById() REQUEST: id: {}", id);
        return libraryService.deleteLibraryById(id)
                .doOnNext(idToRemove -> log.info("deleteLibraryById()::ON_NEXT id: {}, result: null", idToRemove))
                .doOnError(throwable -> log.info("deleteLibraryById()::ON_ERROR throwable: {}", throwable.getMessage()));
//                .onErrorMap(throwable -> new ResourceNotFoundException(id));
    }

    @Override
    public Mono<LibraryResponseDto> getLibraryById(final String id) {
        log.info("getLibraryById() REQUEST: id: {}", id);
        return libraryService.getLibraryById(id)
                .doOnNext(library -> log.info("getLibraryById()::ON_NEXT id: {}, result: library: {}", id, library))
                .doOnError(throwable -> log.info("getLibraryById()::ON_ERROR throwable: {}", throwable.getMessage()))
                .switchIfEmpty(Mono.error(NoContentException::new))
                .map(LibraryTransformer::libraryToLibraryResponseDto);
    }

    @Override
    public Flux<LibraryResponseDto> getLibraries(final String name, final List<String> scholarlyArticleIds) {
        log.info("getLibraries() fetch from LibraryProviderImpl");
        return libraryService.getLibraries(name, scholarlyArticleIds)
                .doOnNext(libraries -> log.info("getLibraries() result: library {}", libraries))
                .doOnError(throwable -> log.info("getLibraries()::ON_ERROR throwable: {}", throwable.getMessage()))
                .map(LibraryTransformer::libraryToLibraryResponseDto);
    }
}
