package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data // 외부에서 데이터 사용 가능
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment 설정했다는 표시를 위한
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
