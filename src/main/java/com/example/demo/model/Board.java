package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data // 외부에서 데이터 사용 가능
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment 설정했다는 표시를 위한
    private Long id;
    @NotNull
    @Size(min=2, max=30, message = "2 글자 이상 30 글자 이하로 작성해주세요.") // 제목은 2 글자에서 30 글자 사이
    private String title;
    private String content;
}
