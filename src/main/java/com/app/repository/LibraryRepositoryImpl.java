package com.app.repository;

import com.app.model.domain.Library;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Repository
public class LibraryRepositoryImpl implements LibraryRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<Library> createLibrary(final Library library) {
        log.info("createLibrary() for library: {}", library);
        return reactiveMongoTemplate.save(library, Library.COLLECTION_NAME);
    }

    @Override
    public Mono<UpdateResult> updateLibrary(final String id, final Library library) {
        log.info("updateLibrary(), for id: {}", id);

        Criteria criteria = Criteria.where("id").is(id);
        Query query = Query.query(criteria);

        Update update = new Update();
        update.set(Library.NAME_FIELD, library.getName());
        update.set(Library.ADDRESS_FIELD, library.getAddress());
        update.set(Library.CITY_FIELD, library.getCity());
        update.set(Library.SCHOLARlY_ARTICLE_FIELD, library.getScholarlyArticles());
        update.set(Library.BOOKS_FIELD, library.getBooks());

        return reactiveMongoTemplate.updateFirst(query, update, Library.class, Library.COLLECTION_NAME);
    }

    @Override
    public Mono<DeleteResult> deleteLibraryById(final String id) {
        log.info("deleteLibraryById(), for id: {}", id);

        final Criteria criteria = Criteria.where("id").is(id);
        final Query query = Query.query(criteria);

        return reactiveMongoTemplate.remove(query, Library.class, Library.COLLECTION_NAME);
    }

    @Override
    public Mono<Library> getLibraryById(final String id) {
        log.info("getLibraryById(), for id: {}", id);
        return reactiveMongoTemplate.findById(id, Library.class, Library.COLLECTION_NAME);
    }

    @Override
    public Flux<Library> getLibraries(final String name, final List<String> scholarlyArticleIds) {
        log.info("getLibraries() fetch from libraryRepositoryImpl");

        final Criteria criteria = new Criteria();
        final Query query = Query.query(criteria);

        if (name != null) {
            log.info("getLibrariesByName, for name: {}", name);
            criteria.and(Library.NAME_FIELD).is(name);
            return reactiveMongoTemplate.find(query, Library.class, Library.COLLECTION_NAME);
        } else if (scholarlyArticleIds != null) {
            log.info("getLibrariesByScholarlyArticlesIds, for scholarlyArticleIdsIds: {}", scholarlyArticleIds);
            criteria.and("scholarlyArticles._id").in(scholarlyArticleIds);
            return reactiveMongoTemplate.find(query, Library.class, Library.COLLECTION_NAME);
        } else
            log.info("getLibraries() from libraryRepositoryImpl");
        return reactiveMongoTemplate.findAll(Library.class, Library.COLLECTION_NAME);
    }
}
