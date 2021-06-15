package com.example.AuthService.service;

import com.example.AuthService.model.Authority;

import java.util.List;

public interface AuthorityService {
    List<Authority> findById(Integer id);
    List<Authority> findByname(String name);
}
