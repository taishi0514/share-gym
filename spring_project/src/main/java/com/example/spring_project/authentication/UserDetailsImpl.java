package com.example.spring_project.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.spring_project.entity.UserInfo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDetailsImpl implements UserDetails{

    private UserInfo user;

    @SuppressWarnings("unused")
    private UserDetails userDetails;

    public UserDetailsImpl(UserInfo user, UserDetails userDetails) {
        this.user = user;
        this.userDetails = userDetails;
    }

    public UserInfo getUser() {
        return user;
    }


    private Collection<? extends GrantedAuthority> authorities;

    public Integer getUserId() {
        return user.getUserId();
    }

    public String getEmail() {
        return user.getEmail();
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
