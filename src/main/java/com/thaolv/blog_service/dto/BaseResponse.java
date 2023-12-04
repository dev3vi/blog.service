package com.thaolv.blog_service.dto;

import lombok.Data;

@Data
public class BaseResponse<T> {
    private String code;
    private String message;
    private T data;

    public BaseResponse() {
        this.code = "99";
        this.message = "Error!";
        this.data = null;
    }
}
