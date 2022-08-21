package com.song.springbootlearn.springboot.entity;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface ReaderRepository extends JpaRepository<Reader,String> {
}
