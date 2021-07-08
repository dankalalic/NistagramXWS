package com.example.PostService.Controller;

import com.example.PostService.Model.*;
import com.example.PostService.Service.PostService;
import com.example.PostService.Service.RegistrovaniKorisnikService;
import com.example.PostService.Service.SadrzajService;
import com.example.PostService.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
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

    @Autowired
    private TokenUtils tokenUtils;

    /*@PostMapping(value="/getpictures", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Sadrzaj>> getRegistrovaniKorisnikPictures(@RequestBody RegistrovaniKorisnikDto registrovaniKorisnikDto){
        RegistrovaniKorisnik registrovaniKorisnik=registrovaniKorisnikService.findonebyid(registrovaniKorisnikDto.getId());
        Set<Sadrzaj> list=registrovaniKorisnik.getPosts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }*/

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/createposts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> createpost(@RequestBody SadrzajDTO sadrzajDTO, @RequestHeader(value="Authorization") String token) throws Exception {
        String role = tokenUtils.getRoleFromToken(token);
        if (role.equals("agent") || role.equals("user")) {
            Integer userId = tokenUtils.getIdFromToken(token);
            return new ResponseEntity<>(postService.create(sadrzajDTO), HttpStatus.OK);
        } else {
            throw new Exception("Zabranjeno");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/pregledNeprikladnogSadrzaja")
    public ResponseEntity<Set<SadrzajReturnDTO>> pregledNeprikladnogSadrzaja(@RequestHeader(value="Authorization") String token) throws Exception {
        String role = tokenUtils.getRoleFromToken(token);
        if (role.equals("admin")) {
            return new ResponseEntity<>(postService.PregledNeprikladnogSadrzaja(), HttpStatus.OK);
        } else {
            throw new Exception("Zabranjeno");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/ukloniSadrzaj", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StringDTO> ukloniSadrzaj(@RequestBody IdDTO idDTO, @RequestHeader(value="Authorization") String token) throws Exception {
        String role = tokenUtils.getRoleFromToken(token);
        if (role.equals("admin")) {
            return new ResponseEntity<>(postService.ukloni(idDTO), HttpStatus.OK);
        } else {
            throw new Exception("Zabranjeno");
        }
    }


    @PostMapping(value="/ugasiSvePostoveUsera", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> ugasiSvePostoveUsera(@RequestBody StringDTO stringDTO, @RequestHeader(value="Authorization") String token) throws Exception {
        String role = tokenUtils.getRoleFromToken(token);
        if (role.equals("admin")) {
            return new ResponseEntity<>(postService.ugasiSvePostoveUsera(stringDTO.getString()), HttpStatus.OK);
        } else {
            throw new Exception("Zabranjeno");
        }
    }

}
