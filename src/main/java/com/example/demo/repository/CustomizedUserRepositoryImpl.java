package com.example.demo.repository;

import com.example.demo.model.QUser;
import com.example.demo.model.User;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// Impl 필수적으로 끝에 작성해야 한다.
class CustomizedUserRepositoryImpl implements CustomizedUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void findByUsernameCustom(String username) {
//        원하는 쿼리 작성
        QUser qUser = QUser.user;
        JPAQuery<?> query = new JPAQuery<Void>(entityManager);
        List<User> bob = query.select(qUser)
                .from(qUser)
                .where(qUser.username.contains(username))
                .fetch(); // fetch() => List
    }
}
