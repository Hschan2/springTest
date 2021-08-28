package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data // 외부에서 데이터 사용 가능
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment 설정했다는 표시를 위한
    private Long id;

    private String username;
    private String password;
    private Boolean enabled;

//    For Join
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")) // Join될 상대 테이블
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user") // 양방향
    private List<Board> boards = new ArrayList<>();
}
