package com.example.jspdemo.service;

import com.example.jspdemo.model.PbfVvsUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {
    private PbfVvsUser pbfVvsUser;

    public UserDetailsImpl(PbfVvsUser pbfVvsUser) {
        this.pbfVvsUser = pbfVvsUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return pbfVvsUser.getUserPassword();
    }

    @Override
    public String getUsername() {
        return pbfVvsUser.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
