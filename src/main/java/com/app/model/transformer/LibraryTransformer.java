package com.app.model.transformer;

import com.app.model.domain.Library;
import com.app.model.dto.library.LibraryRequestDto;
import com.app.model.dto.library.LibraryResponseDto;


public class LibraryTransformer {

    public static LibraryResponseDto libraryToLibraryResponseDto(final Library library) {
        return LibraryResponseDto
                .builder()
                .name(library.getName())
                .address(library.getAddress())
                .city(library.getCity())
                .scholarlyArticles(ScholarlyArticleTransformer.scholarlyArticleListToScholarlyArticleResponseDtoList(library.getScholarlyArticles()))
                .books(BookTransformer.bookListToBookResponseDtoList(library.getBooks()))
                .build();
    }

    public static Library libraryRequestDtoToLibrary(final LibraryRequestDto libraryRequestDto) {
        return Library
                .builder()
                .name(libraryRequestDto.getName())
                .address(libraryRequestDto.getAddress())
                .city(libraryRequestDto.getCity())
                .scholarlyArticles(ScholarlyArticleTransformer.scholarlyArticleRequestDtoListToScholarlyArticleList(libraryRequestDto.getScholarlyArticles()))
                .books(BookTransformer.bookRequestDtoListToBookList(libraryRequestDto.getBooks()))
                .build();
    }

    public static LibraryRequestDto libraryToLibraryRequestDto(final Library library) {
        return LibraryRequestDto
                .builder()
                .name(library.getName())
                .address(library.getAddress())
                .city(library.getCity())
                .scholarlyArticles(ScholarlyArticleTransformer.scholarlyArticleListToScholarlyArticleRequestDtoList(library.getScholarlyArticles()))
                .books(BookTransformer.bookListToBookRequestDtoList(library.getBooks()))
                .build();
    }

    public static Library libraryResponseDtoToLibrary(final LibraryResponseDto libraryResponseDto) {
        return Library
                .builder()
                .name(libraryResponseDto.getName())
                .address(libraryResponseDto.getAddress())
                .city(libraryResponseDto.getCity())
                .scholarlyArticles(ScholarlyArticleTransformer.scholarlyArticleResponseDtoListToScholarlyArticleList(libraryResponseDto.getScholarlyArticles()))
                .books(BookTransformer.bookResponseDtoListToBookList(libraryResponseDto.getBooks()))
                .build();
    }
}
