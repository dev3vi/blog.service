package com.thaolv.blog_service.controller;


import com.thaolv.blog_service.config.security.JwtTokenProvider;
import com.thaolv.blog_service.dto.request.UserDTO;
import com.thaolv.blog_service.dto.response.LoginRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserJwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/authenticate")
    private LoginRes authenticateUser(@RequestBody UserDTO userDTO) throws Exception {
        LoginRes response = new LoginRes();
        //Xác thực từ username và password.
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDTO.getUsername(),userDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            // Nếu không xảy ra exception tức là thông tin hợp lệ
            // Set thông tin authentication vào Security Context
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.generateToken(userDTO.getUsername());
            response.setUsername(authentication.getName());
            response.setRole(authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
            response.setToken(jwt);
        } catch (Exception exception) {
            log.error("authentication fail", exception);
            throw new ServerException("ErrorCode.AUTHEN_ERROR");
        }
        return response;
    }

    @GetMapping("/get-user-info")
    public String currentUserNameSimple() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
