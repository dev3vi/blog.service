package com.thaolv.blog_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "log_info")
public class LogInfo {
    @Id
    private Integer id;
    private String time;
    private String ip;
    private String infoDevice;
}
