package com.example.followerservice;

import com.example.followerservice.model.DTO.ListIntegerWrapper;
import com.example.followerservice.model.User;
import com.example.followerservice.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public ListIntegerWrapper getFollowing(Integer id) {
        User user = this.followerRepository.findOneById(id);
        List<User> following = followerRepository.findAll();
        for (User user1 : following) {
            Set<User> following1 = user1.getFollowers();
            if (!following1.contains(user)) {
                following.remove(user1);
            }
        }

        List<Integer> followingIds = new ArrayList<>();
        for (User user1 : following) {
            followingIds.add(user1.getId());
        }

        return new ListIntegerWrapper(followingIds);
    }

    public ListIntegerWrapper getPublic() {
        List<User> publics = followerRepository.findByIsprivate(false);
        List<Integer> publicsIds = new ArrayList<>();
        for (User user : publics) {
            publicsIds.add(user.getId());
        }
        return new ListIntegerWrapper(publicsIds);
    }

}
