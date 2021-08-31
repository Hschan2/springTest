package com.example.demo.controller;

import com.example.demo.model.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

//For REST API
@RestController
@RequestMapping("/api")
public class BoardApiController {

    @Autowired
    private BoardRepository boardRepository;

//    Select for All
//    Add Search using title
//    Add Search using title or Content
//    Content Param => @RequestParam(required = false, defaultValue = ""
    @GetMapping("/boards")
    List<Board> all(@RequestParam(required = false, defaultValue = "") String title, @RequestParam(required = false, defaultValue = "") String content) {
        if (StringUtils.isEmpty(title)) {
//        if (StringUtils.isEmpty(title) && StringUtils.isEmpty(content)) {
            return boardRepository.findAll();
        } else {
//            return boardRepository.findByTitle(title);
            return boardRepository.findByTitleOrContent(title, content);
//            return boardRepository.findByTitleContaining(title);
        }
    }

//    Insert
    @PostMapping("/boards")
    Board newBoard(@RequestBody Board newBoard) {
        return boardRepository.save(newBoard);
    }

//    Select for one
//    ID 있으면 값 가져오고 없으면 Null 값
    @GetMapping("/boards/{id}")
    Board one(@PathVariable Long id) {
        return boardRepository.findById(id).orElse(null);
    }

//    Update
    @PutMapping("/boards/{id}")
    Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {
        return boardRepository.findById(id)
                .map(board -> {
                    board.setTitle(newBoard.getTitle());
                    board.setContent(newBoard.getContent());
                    return boardRepository.save(board);
                })
                .orElseGet(() -> {
                    newBoard.setId(id);
                    return boardRepository.save(newBoard);
                });
    }

//    Delete
    @Secured("ROLE_ADMIN") // 외부에서 삭제하는 보안 오류 예방. 즉, ROLE_ADMIN 권한만 삭제 가능
    @DeleteMapping("/boards/{id}")
    void deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
    }
}
