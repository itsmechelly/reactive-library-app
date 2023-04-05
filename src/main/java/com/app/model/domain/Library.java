package com.app.model.domain;

import com.app.core.model.domain.BaseDomain;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(collection = Library.COLLECTION_NAME)
public class Library extends BaseDomain {

    public static final String COLLECTION_NAME = "library";
    public static final String NAME_FIELD = "name";
    public static final String ADDRESS_FIELD = "address";
    public static final String CITY_FIELD = "city";
    public static final String SCHOLARlY_ARTICLE_FIELD = "scholarlyArticles";
    public static final String BOOKS_FIELD = "books";

    @Field(NAME_FIELD)
    private String name;

    @Field(ADDRESS_FIELD)
    private String address;

    @Field(CITY_FIELD)
    private String city;

    @Field(SCHOLARlY_ARTICLE_FIELD)
    private List<ScholarlyArticle> scholarlyArticles;

    @Field(BOOKS_FIELD)
    private List<Book> books;
}
