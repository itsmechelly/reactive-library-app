package com.app.model.domain;

import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Builder
public class ScholarlyArticle {

    @Field("_id")
    @Builder.Default
    private String id = new ObjectId().toString();
    private String name;
    private Integer floorNum;
    private Integer rowNum;
    private Integer shelfNum;
}
