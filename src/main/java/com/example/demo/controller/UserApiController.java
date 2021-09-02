package com.example.demo.controller;

import com.example.demo.model.Board;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j // Log 출력 가능
public class UserApiController {

    @Autowired
    private UserRepository userRepository;

//    Custom Query 적용
    @GetMapping("/users")
    List<User> all(@RequestParam(required = false) String method, @RequestParam(required = false) String text) {
//        List<User> users = userRepository.findAll();
//        log.debug("getBoards().size() : {}", users.get(0).getBoards().size());
        List<User> users = null;
        if ("query".equals(method)) {
            users = userRepository.findByUsernameQuery(text);
        } else if ("nativeQuery".equals(method)) {
            users = userRepository.findByUsernameNativeQuery(text);
        } else if ("querydsl".equals(method)) {
//            QCustomer customer = QCustomer.customer;
//            Predicate predicate = user.firstname.equalsignoreCase("dave")
//                    .and(user.lastname.startsWithIgnoreCase("mathews"));
//            userRepository.findAll(predicate);
        } else {
            users = userRepository.findAll();
        }
        return users;
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
//                    User 클래스의 boards가 orphanRemoval = true일 경우, 갖고 있는 모든 board에 영향
//                    user.setBoards(newUser.getBoards());
//                    user의 board를 모두 삭제
                    user.getBoards().clear();
//                    지금 받은 데이터로 user의 board의 값을 변경
//                    즉, 해당 user가 가지고 있는 board 데이터를 모두 삭제하고 해당 board만 추가
                    user.getBoards().addAll(newUser.getBoards());
                    for (Board board : user.getBoards()) {
                        board.setUser(user);
                    }
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
