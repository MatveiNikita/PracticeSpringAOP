package com.learnAOP.demo.util;

import com.learnAOP.demo.entity.Book;
import lombok.Data;
import java.util.List;
@Data
public class CustomResponse<B> {

    private int code;

    private String message;
    private List<Book> responseList;

    public CustomResponse(List<Book> responseList, CustomStatus status) {
        this.code  = status.getCode();
        this.message = status.getMessage();
        this.responseList = responseList;
    }
}
