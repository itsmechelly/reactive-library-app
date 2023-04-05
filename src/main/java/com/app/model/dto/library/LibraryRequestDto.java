package com.app.model.dto.library;

import com.app.model.dto.book.BookRequestDto;
import com.app.model.dto.scholarly.article.ScholarlyArticleRequestDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class LibraryRequestDto {

    @NotEmpty
    private String name;
    private String address;
    private String city;
    private List<ScholarlyArticleRequestDto> scholarlyArticles;
    private List<BookRequestDto> books;
}
