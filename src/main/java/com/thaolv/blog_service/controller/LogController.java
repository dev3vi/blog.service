package com.thaolv.blog_service.controller;

import com.thaolv.blog_service.entity.LogInfo;
import com.thaolv.blog_service.repository.LogInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class LogController {

    private final LogInfoRepository logInfoRepository;

    @PostMapping("/log-info")
    public void logInfoUser(@RequestBody LogInfo logInfo) {
        logInfoRepository.save(logInfo);
    }
}
