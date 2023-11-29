package com.thaolv.blog_service.config.security;

import com.thaolv.blog_service.entity.Roles;
import com.thaolv.blog_service.entity.Users;
import com.thaolv.blog_service.model.LoginUserInfo;
import com.thaolv.blog_service.repository.RolesRepository;
import com.thaolv.blog_service.repository.UsersRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;

    public UserDetailServiceImpl(UsersRepository usersRepository, RolesRepository rolesRepository) {
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users userSys = this.usersRepository.findById(username).orElseThrow(()-> new UsernameNotFoundException("Username not found!"));
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (!Objects.isNull(userSys)) {
            Roles roles = rolesRepository.findById(userSys.getRoleId()).orElseThrow();
            GrantedAuthority authority = new SimpleGrantedAuthority(roles.getRoleCode());
            authorities.add(authority);
        }
        return new LoginUserInfo(userSys, authorities);
    }
}
