package com.example.demo.repository;

import com.example.demo.model.QUser;
import com.example.demo.model.User;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// Impl 필수적으로 끝에 작성해야 한다.(Customize Interface를 사용하기 위해서)
class CustomizedUserRepositoryImpl implements CustomizedUserRepository {

    @PersistenceContext // 실제 DB에 저장하는 것이 아닌 PersistenceContext 통해 Entity 영속화
    private EntityManager entityManager;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findByUsernameCustom(String username) {
//        원하는 쿼리 작성
        QUser qUser = QUser.user;
        JPAQuery<?> query = new JPAQuery<Void>(entityManager);
        List<User> users = query.select(qUser)
                .from(qUser)
                .where(qUser.username.contains(username))
                .fetch(); // fetch() => List

        return users;
    }

    @Override
    public List<User> findByUsernameJdbc(String username) {
        String sql = "SELECT * FROM USER WHERE username like ?";

//        하나의 데이터만 가져오기
//        return (User) jdbcTemplate.queryForObject(
//                sql,
//                new Object[]{id},
//                new BeanPropertyRowMapper(User.class)); // BeanPropertyRowMapper => 클래스를 전체를 가져올 수 있다.

//        해당된 모든 데이터 가져오기
        List<User> users = jdbcTemplate.query(
                sql,
                new Object[]{"%" + username + "%"}, // 받은 파라미터 가져오기
                new BeanPropertyRowMapper(User.class));

        return users;


    }
}
