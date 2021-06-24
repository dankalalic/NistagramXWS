package com.example.followerservice;

import com.example.followerservice.model.User;
import com.example.followerservice.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private FollowerRepository followerRepository;

    public User save(User user){

        User userr= new User();
        userr=this.followerRepository.save(user);
        return userr;

    }

    public User findById(Integer id) {
        return followerRepository.findOneById(id);
    }


}
