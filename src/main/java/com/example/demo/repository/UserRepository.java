package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>, CustomizedUserRepository {
//   FetchType, 데이터 조회 중 N + 1 문제로 문제가 발생할 경우, 여러 쿼리가 아닌 하나의 조인으로 데이터 조회 => 성능 향상
    @EntityGraph(attributePaths = { "boards" })
    List<User> findAll();

    User findByUsername(String username);

//    Custom Query
//    Query 문에서 u는 *과 같음
    @Query("select u from User u where u.username like %?1%") // %?1% => 첫 번째 파라미터
    List<User> findByUsernameQuery(String username);

//    순수 SQL Query
    @Query(value = "select * from User u where u.username like %?1%", nativeQuery = true)
    List<User> findByUsernameNativeQuery(String username);
}
