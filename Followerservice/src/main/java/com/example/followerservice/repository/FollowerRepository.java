package com.example.followerservice.repository;

import com.example.followerservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowerRepository extends JpaRepository<User, Integer> {
    User findOneById (Integer id);
}
