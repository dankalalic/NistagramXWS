package com.example.followerservice.repository;

import com.example.followerservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowerRepository extends JpaRepository<User, Integer> {
    User findOneById (Integer id);

    List<User> findByIsprivate(Boolean isprivate);
}
