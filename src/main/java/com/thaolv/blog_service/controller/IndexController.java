package com.thaolv.blog_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j(topic = "APPLICATION")
public class IndexController {

    @GetMapping("/ping")
    private String ping() {
        return "Happy new year!!!";
    }

}
