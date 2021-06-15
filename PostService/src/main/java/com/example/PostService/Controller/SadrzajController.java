package com.example.PostService.Controller;

import com.example.PostService.Model.Sadrzaj;
import com.example.PostService.Service.SadrzajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sadrzaj")
public class SadrzajController {
    private SadrzajService sadrzajService;

    @Autowired
    public void setSadrzajService(SadrzajService sadrzajService) {
        this.sadrzajService = sadrzajService;
    }







}
