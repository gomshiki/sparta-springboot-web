package com.sparta.springboot_web.ui;

import com.sparta.springboot_web.dto.BoardRequestDto;
import com.sparta.springboot_web.dto.BoardResponseDto;
import com.sparta.springboot_web.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/post")
    public ResponseEntity<BoardResponseDto> saveBoard(@RequestBody BoardRequestDto boardRequestDto) {
        log.info("게시글 저장 : {}", boardRequestDto.toString());
        BoardResponseDto boardResponseDto = boardService.saveBoard(boardRequestDto);
        return ResponseEntity.ok(boardResponseDto);
    }

    @GetMapping("/post")
    public ResponseEntity<List<BoardResponseDto>> getBoards() {
        List<BoardResponseDto> boards = boardService.findAllBoards();
        return ResponseEntity.ok(boards);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<BoardResponseDto> updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto) {
        BoardResponseDto updateBoard = boardService.updateBoard(id, boardRequestDto);
        return ResponseEntity.ok(updateBoard);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id) throws IllegalAccessError {
        try {
            boardService.deleteBoard(id);
            Map<String, String> response = new HashMap<>();
            response.put("msg", "삭제완료");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            Map<String, String> response = new HashMap<>();
            response.put("msg", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
