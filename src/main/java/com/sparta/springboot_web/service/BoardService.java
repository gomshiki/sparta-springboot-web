package com.sparta.springboot_web.service;

import com.sparta.springboot_web.dto.BoardRequestDto;
import com.sparta.springboot_web.dto.BoardResponseDto;
import com.sparta.springboot_web.entity.Board;
import com.sparta.springboot_web.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponseDto saveBoard(BoardRequestDto boardRequestDto) {
        Board board = BoardRequestDto.from(boardRequestDto);
        Board savedBoard = boardRepository.save(board);
        log.info("저장된 게시글 : {}", savedBoard);
        return BoardResponseDto.from(savedBoard);
    }

    public List<BoardResponseDto> findAllBoards() {
        List<Board> savedBoards = boardRepository.findAll();
        return savedBoards.stream().map(BoardResponseDto::from).toList();
    }

    public BoardResponseDto updateBoard(Long id, BoardRequestDto boardRequestDto) {
        Board board = new Board(
                id, boardRequestDto.getUsername(), boardRequestDto.getTitle(),
                boardRequestDto.getContent(), boardRequestDto.getPrice()
        );
        Board updateBoard = boardRepository.save(board);

        return BoardResponseDto.from(updateBoard);
    }

    public void deleteBoard(Long id) {
        if(!boardRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid Board ID: " + id);
        }
        boardRepository.deleteById(id);
    }
}
