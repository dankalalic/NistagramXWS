package com.example.PostService.Controller;

import com.example.PostService.Model.Sadrzaj;
import com.example.PostService.Service.SadrzajService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.PostService.DTO.IdDTO;
import com.example.PostService.DTO.SadrzajUserDTO;
import com.example.PostService.DTO.StringDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sadrzaj")
public class SadrzajController {

    private SadrzajService sadrzajService;

    @Autowired
    public SadrzajService setSadrzajService(SadrzajService sadrzajService) {
        return this.sadrzajService = sadrzajService;
    }

    @PostMapping("/findByLokacija")
    public ResponseEntity<List<Sadrzaj>> findByLokacija(@RequestBody StringDTO stringDTO){
        return new ResponseEntity<>(sadrzajService.findByLokacija(stringDTO.getString()), HttpStatus.OK);
    }

    @PostMapping("/findByTag")
    public ResponseEntity<List<Sadrzaj>> findByTag(@RequestBody StringDTO stringDTO){
        return new ResponseEntity<>(sadrzajService.findByTag(stringDTO.getString()), HttpStatus.OK);
    }

    @PostMapping("/findByProfil")
    public ResponseEntity<List<Sadrzaj>> findByProfil(@RequestBody IdDTO idDTO){
        return new ResponseEntity<>(sadrzajService.findByProfil(idDTO.getId()), HttpStatus.OK);
    }

    @PostMapping("/like")
    public ResponseEntity<Sadrzaj> like(@RequestBody SadrzajUserDTO sadrzajUserDTO) {
        return new ResponseEntity<>( sadrzajService.like(sadrzajUserDTO), HttpStatus.OK);
    }

    @PostMapping("/dislike")
    public ResponseEntity<Sadrzaj> dislike(@RequestBody SadrzajUserDTO sadrzajUserDTO) {
        return new ResponseEntity<>( sadrzajService.dislike(sadrzajUserDTO), HttpStatus.OK);
    }
}
