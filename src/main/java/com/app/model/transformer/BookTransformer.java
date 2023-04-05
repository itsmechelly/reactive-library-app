package com.app.model.transformer;

import com.app.model.domain.Book;
import com.app.model.dto.book.BookRequestDto;
import com.app.model.dto.book.BookResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class BookTransformer {

    public static List<BookResponseDto> bookListToBookResponseDtoList(final List<Book> books) {
        return books.stream().map(book -> BookResponseDto
                        .builder()
                        .name(book.getName())
                        .floorNum(book.getFloorNum())
                        .rowNum(book.getRowNum())
                        .shelfNum(book.getShelfNum())
                        .bookPrice(book.getBookPrice())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<Book> bookRequestDtoListToBookList(final List<BookRequestDto> bookRequestDtos) {
        return bookRequestDtos.stream().map(bookRequestDto -> Book
                        .builder()
                        .name(bookRequestDto.getName())
                        .floorNum(bookRequestDto.getFloorNum())
                        .rowNum(bookRequestDto.getRowNum())
                        .shelfNum(bookRequestDto.getShelfNum())
                        .bookPrice(bookRequestDto.getBookPrice())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<BookRequestDto> bookListToBookRequestDtoList(final List<Book> books) {
        return books.stream().map(book -> BookRequestDto
                        .builder()
                        .name(book.getName())
                        .floorNum(book.getFloorNum())
                        .rowNum(book.getRowNum())
                        .shelfNum(book.getShelfNum())
                        .bookPrice(book.getBookPrice())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<Book> bookResponseDtoListToBookList(final List<BookResponseDto> bookResponseDtos) {
        return bookResponseDtos.stream().map(bookResponseDto -> Book
                        .builder()
                        .name(bookResponseDto.getName())
                        .floorNum(bookResponseDto.getFloorNum())
                        .rowNum(bookResponseDto.getRowNum())
                        .shelfNum(bookResponseDto.getShelfNum())
                        .bookPrice(bookResponseDto.getBookPrice())
                        .build())
                .collect(Collectors.toList());
    }
}
