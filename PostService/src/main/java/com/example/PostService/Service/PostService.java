package com.example.PostService.Service;

import com.example.PostService.Model.Post;
import com.example.PostService.Model.RegistrovaniKorisnik;
import com.example.PostService.Repository.PostRepository;
import com.example.PostService.dto.RegistrovaniKorisnikDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PostService {
    private PostRepository postRepository;

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /*public Set<Post> findallbyregistrovanikorisnik(RegistrovaniKorisnik registrovanikorisnik){
        return postRepository.findAllByRegistrovaniKorisnik(registrovanikorisnik);
    }*/
}
