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

//    OneToMany => 양방향
//    cascade = CascadeType.ALL => User의 값이 변경되면 (삭제 포함) Join된 Board 값도 같이 정
//    orphanRemoval = true => user의 모든 board에 영향, user가 삭제가 되면 user가 가지고 있는 board의 모든 데이터도 삭제
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    FetchType.EAGER => User가 불러와질 때, 해당 board 값들도 같이 가져온다. FetchType.LAZY => user의 board 값들을 사용할 때 가져온다.
//    Many로 끝나는 것은 LAZY 사용 (필요없는 데이터 불러오는 것을 제거)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Board> boards = new ArrayList<>();
}
