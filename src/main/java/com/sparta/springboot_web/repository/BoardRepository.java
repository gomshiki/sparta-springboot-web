package com.sparta.springboot_web.repository;

import com.sparta.springboot_web.entity.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findAll();
}
