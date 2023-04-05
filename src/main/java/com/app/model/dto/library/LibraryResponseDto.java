package com.app.model.dto.library;

import com.app.model.dto.book.BookResponseDto;
import com.app.model.dto.scholarly.article.ScholarlyArticleResponseDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class LibraryResponseDto {

    @NotEmpty
    private String name;
    private String address;
    private String city;
    private List<ScholarlyArticleResponseDto> scholarlyArticles;
    private List<BookResponseDto> books;
}
