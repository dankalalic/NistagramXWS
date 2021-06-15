package com.example.PostService.Controller;


import com.example.PostService.Model.Post;
import com.example.PostService.Model.RegistrovaniKorisnik;
import com.example.PostService.Model.Sadrzaj;
import com.example.PostService.Service.PostService;
import com.example.PostService.Service.RegistrovaniKorisnikService;
import com.example.PostService.Service.SadrzajService;
import com.example.PostService.dto.RegistrovaniKorisnikDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private PostService postService;
    private RegistrovaniKorisnikService registrovaniKorisnikService;
    private SadrzajService sadrzajService;

    @Autowired
    public void setSadrzajService(SadrzajService sadrzajService) {
        this.sadrzajService = sadrzajService;
    }



    @Autowired
    public void setRegistrovaniKorisnikService(RegistrovaniKorisnikService registrovaniKorisnikService) {
        this.registrovaniKorisnikService = registrovaniKorisnikService;
    }

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value="/getpictures", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Sadrzaj>> getRegistrovaniKorisnikPictures(@RequestBody RegistrovaniKorisnikDto registrovaniKorisnikDto){
        RegistrovaniKorisnik registrovaniKorisnik=registrovaniKorisnikService.findonebyid(registrovaniKorisnikDto.getId());
        Set<Sadrzaj> list=registrovaniKorisnik.getPosts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value="/createposts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> createpost(@RequestBody RegistrovaniKorisnikDto registrovaniKorisnikDto){
        Post post =new Post();
        return null;
    }


}
