package com.thaolv.blog_service.dto.response;

import com.thaolv.blog_service.dto.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class LoginRes extends BaseResponse {
    private String username;
    private List<String> role;
    private String token;
}
