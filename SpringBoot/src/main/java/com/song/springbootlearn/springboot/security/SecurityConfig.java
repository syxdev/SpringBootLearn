package com.song.springbootlearn.springboot.security;

import com.song.springbootlearn.springboot.entity.Book;
import com.song.springbootlearn.springboot.entity.ReaderRepository;
import com.song.springbootlearn.springboot.entity.ReadingListRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.init.ResourceReaderRepositoryPopulator;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.io.Reader;
import java.util.Optional;
@Profile("production")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private ReaderRepository readerRepository;


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/").access("hasRole('READER')")//要求登录者有READER角色
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")//设置登录表单的路径
                .failureUrl("/login?error=true");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username){
                return readerRepository.findById(username).orElse(null);
            }
        });
    }

}
