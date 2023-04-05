package com.app.repository;

import com.app.model.domain.Library;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface LibraryRepository {

    Mono<Library> createLibrary(Library library);

    Mono<UpdateResult> updateLibrary(String id, Library library);

    Mono<DeleteResult> deleteLibraryById(String id);

    Mono<Library> getLibraryById(String id);

    Flux<Library> getLibraries(String name, List<String> scholarlyArticleIds);
}
