package com.example.demo.repository;

import com.example.demo.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

//    제목으로 검색하기 메소드
    List<Board> findByTitle(String title);
//    제목 또는 내용으로 검색하기 메소드
    List<Board> findByTitleOrContent(String title, String content);
//    검색 단어가 포함된 제목 검색하기 메소드
    List<Board> findByTitleContaining(String title);
}
