package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//   FetchType, 데이터 조회 중 N + 1 문제로 문제가 발생할 경우, 여러 쿼리가 아닌 하나의 조인으로 데이터 조회 => 성능 향상
    @EntityGraph(attributePaths = {"boards"})
    List<User> findAll();

    User findByUsername(String username);
}
