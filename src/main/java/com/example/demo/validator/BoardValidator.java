package com.example.demo.validator;

import com.example.demo.model.Board;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

//유효성 검사 직접 코드
@Component
public class BoardValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Board.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Board board = (Board) o;
        if (StringUtils.isEmpty(board.getContent())) {
            errors.rejectValue("content", "key", "내용을 입력하세요.");
        }
    }
}
