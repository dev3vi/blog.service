package com.thaolv.blog_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    @NonNull
    private String username;
    private Integer roleId;
    private String email;
    private String password;
    private String fullName;
    private String token;
    private boolean isActivated;
}
