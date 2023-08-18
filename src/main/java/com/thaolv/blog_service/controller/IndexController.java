package com.thaolv.blog_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class IndexController {

    @GetMapping("/test")
    private String test() {
        return "ok";
    }

    @PostMapping("/test")
    private String test2() {
        return "okk";
    }

    @PostMapping("/authenticate")
    private String authenticate() {
        return "todo";
    }

}
