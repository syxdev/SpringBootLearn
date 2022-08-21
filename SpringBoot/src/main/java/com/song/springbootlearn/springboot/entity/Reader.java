package com.song.springbootlearn.springboot.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;
@Entity
public class Reader implements UserDetails {

    private static  final long serialversionUID=1L;

    @Id
    private String username;
    private String fullname;
    private String password;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("READER"));//授予READER权限
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {          //不过期，不加锁，不禁用
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {           //不过期，不加锁，不禁用
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {      //不过期，不加锁，不禁用
        return true;
    }

    @Override
    public boolean isEnabled() {                    //不过期，不加锁，不禁用
        return true;
    }
}
