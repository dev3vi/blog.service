package com.thaolv.blog_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@RestController
@RequestMapping("/api")
@Slf4j(topic = "APPLICATION")
public class IndexController {

    @GetMapping("/ping")
    private String ping() {
        return "ping success!";
    }

}
