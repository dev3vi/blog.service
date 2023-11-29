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

    @GetMapping
    private String index() throws IOException {
        FTPClient ftpClient = this.connect("127.0.0.1", 21, "admin", "admin");
        ftpClient.changeWorkingDirectory("/file-test");
        Objects.requireNonNull(ftpClient).deleteFile("test.txt");
        ftpClient.disconnect();
        return "123";
    }

    public static FTPClient connect(String server, int port, String account, String password) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            boolean isSuccessLogin = ftpClient.login(account, password);
            if (isSuccessLogin) {
                ftpClient.enterLocalPassiveMode();
                ftpClient.setControlEncoding(StandardCharsets.UTF_8.name());// For list file name
                log.info(String.format("Successfully connect to %s ", ftpClient.getRemoteAddress()));
                return ftpClient;
            }
            log.error(String.format("Cannot connect FTP Server: %s", server));
            return null;
        } catch (IOException ioe) {
            log.error(String.format("Cannot connect FTP Server: %s", server));
            return null;
        }
    }



}
