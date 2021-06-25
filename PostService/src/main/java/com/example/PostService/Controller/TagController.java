package com.example.PostService.Controller;

import com.example.PostService.Model.Komentar;
import com.example.PostService.Model.StringDTO;
import com.example.PostService.Model.Tagovi;
import com.example.PostService.Repository.KomentarRepository;
import com.example.PostService.Repository.TagRepository;
import com.example.PostService.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tagovi")
public class TagController {

    private TagService tagService;

    @Autowired
    public TagService setTagService(TagService tagService) {
        return this.tagService = tagService;
    }

    @PostMapping("/findByNaziv")
    public  ResponseEntity<Tagovi> findByNaziv(@RequestBody StringDTO stringDTO){
        return new ResponseEntity<>(tagService.findByNaziv(stringDTO.getString()), HttpStatus.OK);
    }
}
