package com.example.messagesservice.repository;

import com.example.messagesservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findOneById(Integer id);
}
