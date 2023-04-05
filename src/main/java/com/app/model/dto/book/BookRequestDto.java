package com.app.model.dto.book;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookRequestDto {

    private String name;
    private Integer floorNum;
    private Integer rowNum;
    private Integer shelfNum;
    private double bookPrice;
}
