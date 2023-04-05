package com.app.model.dto.scholarly.article;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScholarlyArticleResponseDto {

    private String name;
    private Integer floorNum;
    private Integer rowNum;
    private Integer shelfNum;
}
