package com.app.service;

import com.app.model.domain.Library;
import com.app.repository.LibraryRepository;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;

    @Override
    public Mono<Library> createLibrary(final Library library) {
        log.info("createLibrary() for name: {}", library.getName());
        return libraryRepository.createLibrary(library)
                .doOnNext(createLibrary -> log.info("createLibrary()::ON_NEXT, library: {}", createLibrary))
                .doOnError(throwable -> log.error("createLibrary()::ON_ERROR, throwable: {}", throwable.getMessage()));
    }

    @Override
    public Mono<UpdateResult> updateLibrary(final String id, final Library library) {
        log.info("updateLibrary() REQUEST: name: {}", library.getName());
        return libraryRepository.updateLibrary(id, library)
                .doOnNext(updateLibrary -> log.info("updateLibrary()::ON_NEXT library: {}, result: updateLibrary: {}", library, updateLibrary))
                .doOnError(throwable -> log.info("updateLibrary()::ON_ERROR throwable: {}", throwable.getMessage()));
    }

    @Override
    public Mono<DeleteResult> deleteLibraryById(final String id) {
        log.info("deleteLibraryById() REQUEST: id: {}", id);
        return libraryRepository.deleteLibraryById(id)
                .doOnNext(idToRemove -> log.info("deleteLibraryById()::ON_NEXT id: {}, result: null", idToRemove))
                .doOnError(throwable -> log.info("deleteLibraryById()::ON_ERROR throwable: {}", throwable.getMessage()));
    }

    @Override
    public Mono<Library> getLibraryById(final String id) {
        log.info("getLibraryById(), for id: {}", id);
        return libraryRepository.getLibraryById(id)
                .doOnNext(library -> log.info("getLibraryById()::ON_NEXT, id: {}. result - library: {}", id, library))
                .doOnError(throwable -> log.error("getLibraryById()::ON_ERROR, throwable: {}", throwable.getMessage()));
    }

    @Override
    public Flux<Library> getLibraries(final String name, final List<String> scholarlyArticleIds) {
        log.info("getLibraries() fetch from libraryServiceImpl");
        return libraryRepository.getLibraries(name, scholarlyArticleIds)
                .doOnNext(library -> log.info("getLibraries()::ON_NEXT, libraries: {}", library))
                .doOnError(throwable -> log.error("getLibraries()::ON_ERROR, throwable: {}", throwable.getMessage()));
    }
}
