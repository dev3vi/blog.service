package com.thaolv.blog_service.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class LoginRes {
    private String username;
    private List<String> role;
    private String token;
}
