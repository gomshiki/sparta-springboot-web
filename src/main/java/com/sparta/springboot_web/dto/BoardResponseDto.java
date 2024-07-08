package com.sparta.springboot_web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.springboot_web.entity.Board;

public class BoardResponseDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content")
    private String content;
    @JsonProperty("price")
    private int price;

    public BoardResponseDto() {
    }

    public BoardResponseDto(Long id, String username, String title, String content, int price) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }

    public static BoardResponseDto from(Board board) {
        return new BoardResponseDto(
                board.getId(), board.getUsername(), board.getTitle(), board.getContent(), board.getPrice()
        );
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getPrice() {
        return price;
    }
}
