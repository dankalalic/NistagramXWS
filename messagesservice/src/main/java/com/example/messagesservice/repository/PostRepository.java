package com.example.messagesservice.repository;

import com.example.messagesservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findOneById(Integer id);
}
