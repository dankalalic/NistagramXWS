package com.example.PostService.Service;

import com.example.PostService.Model.Tagovi;
import com.example.PostService.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTML;
import java.util.List;

@Service
public class TagService {
    
    private TagRepository tagRepository;
    
    @Autowired
    public TagRepository setTagRepositoty(TagRepository tagRepository) 
    {
        return this.tagRepository = tagRepository;
    }
    
    public Tagovi findByNaziv(String naziv) {
        return this.tagRepository.findByNaziv(naziv);
    }
}
