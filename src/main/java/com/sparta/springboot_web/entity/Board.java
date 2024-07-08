package com.sparta.springboot_web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;

    public Board() {
    }

    public Board(String username, String title, String content, int price) {
        this(null, username, title, content, price);
    }

    public Board(Long id, String username, String title, String content, int price) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                '}';
    }
}
