package com.thaolv.blog_service.controller;


import com.google.gson.Gson;
import com.thaolv.blog_service.common.Constants;
import com.thaolv.blog_service.config.security.JwtTokenProvider;
import com.thaolv.blog_service.dto.BaseResponse;
import com.thaolv.blog_service.dto.request.UserDTO;
import com.thaolv.blog_service.dto.response.LoginRes;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserJwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
    protected final Gson gson = new Gson();
    private static final Logger authenticateUserLogger = LoggerFactory.getLogger("authenticateUser");
    @PostMapping("/authenticate")
    private BaseResponse<?> authenticateUser(@RequestBody UserDTO userDTO) {
        log.info(gson.toJson(userDTO));
        authenticateUserLogger.info(gson.toJson(userDTO));
        BaseResponse<LoginRes> baseResponse = new BaseResponse<>();
        LoginRes response =  new LoginRes();
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDTO.getUsername(),userDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            // If invalid username, password -> throw Exception here
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // Else if valid username, password
            String jwt = tokenProvider.generateToken(userDTO.getUsername());
            response.setUsername(authentication.getName());
            response.setRole(authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
            response.setToken(jwt);
        } catch (BadCredentialsException e) {
            log.error("Authentication fail", e);
            baseResponse.setStatus(Constants.ERROR_AUTHENTICATION);
            return baseResponse;
        } catch (Exception exception) {
            log.error("Server error", exception);
            baseResponse.setStatus(Constants.ERROR_CODE);
            return baseResponse;
        }
        baseResponse.setData(response);
        baseResponse.setStatus(Constants.SUCCESS_CODE);
        return baseResponse;
    }

    @GetMapping("/get-user-info")
    public String currentUserNameSimple() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @GetMapping("/get-role")
    public Collection<GrantedAuthority> getRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((UsernamePasswordAuthenticationToken) authentication).getAuthorities();
    }
}
