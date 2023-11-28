package com.thaolv.blog_service.model;

import com.thaolv.blog_service.entity.Users;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class LoginUserInfo extends User {

    private String username;
    private String password;
    private String name;
    private boolean isActivated;
    private Collection<GrantedAuthority> authorities;

    public LoginUserInfo(Users users, Collection<GrantedAuthority> authorities) {
        super(users.getUsername(), users.getPassword(), authorities);
        setInfo(users, authorities);
    }

    private void setInfo(Users user, Collection<GrantedAuthority> authorities) {
        this.username = user.getUsername();
        this.name = user.getFullName();
        this.password = user.getPassword();
        this.authorities = authorities;
        this.isActivated = user.isActivated();
    }
}
