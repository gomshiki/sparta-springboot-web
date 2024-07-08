package com.sparta.springboot_web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.springboot_web.entity.Board;
import lombok.Getter;

@Getter
public class BoardRequestDto {

    @JsonProperty("username")
    private String username;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content")
    private String content;
    @JsonProperty("price")
    private int price;

    public BoardRequestDto() {
    }

    public BoardRequestDto(String username, String title, String content, int price) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }

    public static Board from(BoardRequestDto boardRequestDto) {
        return new Board(
                boardRequestDto.getUsername(),
                boardRequestDto.getTitle(),
                boardRequestDto.getContent(),
                boardRequestDto.getPrice()
        );
    }

    @Override
    public String toString() {
        return "BoardRequestDto{" +
                "username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                '}';
    }
}
