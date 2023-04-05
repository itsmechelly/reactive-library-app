package com.app.model.transformer;

import com.app.model.domain.ScholarlyArticle;
import com.app.model.dto.scholarly.article.ScholarlyArticleRequestDto;
import com.app.model.dto.scholarly.article.ScholarlyArticleResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ScholarlyArticleTransformer {

    public static List<ScholarlyArticleResponseDto> scholarlyArticleListToScholarlyArticleResponseDtoList(final List<ScholarlyArticle> scholarlyArticles) {
        return scholarlyArticles.stream().map(scholarlyArticle -> ScholarlyArticleResponseDto
                        .builder()
                        .name(scholarlyArticle.getName())
                        .floorNum(scholarlyArticle.getFloorNum())
                        .rowNum(scholarlyArticle.getRowNum())
                        .shelfNum(scholarlyArticle.getRowNum())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<ScholarlyArticle> scholarlyArticleRequestDtoListToScholarlyArticleList(final List<ScholarlyArticleRequestDto> scholarlyArticleRequestListDto) {
        return scholarlyArticleRequestListDto.stream().map(scholarlyArticleRequestDto -> ScholarlyArticle
                        .builder()
                        .name(scholarlyArticleRequestDto.getName())
                        .floorNum(scholarlyArticleRequestDto.getFloorNum())
                        .rowNum(scholarlyArticleRequestDto.getRowNum())
                        .rowNum(scholarlyArticleRequestDto.getShelfNum())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<ScholarlyArticleRequestDto> scholarlyArticleListToScholarlyArticleRequestDtoList(final List<ScholarlyArticle> scholarlyArticles) {
        return scholarlyArticles.stream().map(scholarlyArticle -> ScholarlyArticleRequestDto
                        .builder()
                        .name(scholarlyArticle.getName())
                        .floorNum(scholarlyArticle.getFloorNum())
                        .rowNum(scholarlyArticle.getRowNum())
                        .shelfNum(scholarlyArticle.getRowNum())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<ScholarlyArticle> scholarlyArticleResponseDtoListToScholarlyArticleList(final List<ScholarlyArticleResponseDto> scholarlyArticleResponseDtoList) {
        return scholarlyArticleResponseDtoList.stream().map(scholarlyArticleResponseDto -> ScholarlyArticle
                        .builder()
                        .name(scholarlyArticleResponseDto.getName())
                        .floorNum(scholarlyArticleResponseDto.getFloorNum())
                        .rowNum(scholarlyArticleResponseDto.getRowNum())
                        .rowNum(scholarlyArticleResponseDto.getShelfNum())
                        .build())
                .collect(Collectors.toList());
    }
}
