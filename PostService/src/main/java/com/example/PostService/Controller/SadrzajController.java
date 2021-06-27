package com.example.PostService.Controller;

import com.example.PostService.Model.*;
import com.example.PostService.Service.SadrzajService;
import com.example.PostService.Model.SadrzajDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
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
    @CrossOrigin(origins = "http://localhost:4200")
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/neprikladanSadrzaj")
    public ResponseEntity<StringDTO> neprikladanSadrzaj(@RequestBody IdDTO idDTO) {

        String s = sadrzajService.prijaviNeprikladanSadrzaj(idDTO);
        StringDTO ss = new StringDTO(s);
        return new ResponseEntity<>(ss, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/sadrzajKorisnikLajkovao")
    public ResponseEntity<Set<SadrzajReturnDTO>> sadrzajKorisnikLajkovao(@RequestBody IdDTO idDTO) {
        return new ResponseEntity<>(sadrzajService.getsadrzajKorisnikLajkovao(idDTO.getId()), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/sadrzajKorisnikDislajkovao")
    public ResponseEntity<Set<SadrzajReturnDTO>> sadrzajKorisnikDislajkovao(@RequestBody IdDTO idDTO) {
        return new ResponseEntity<>(sadrzajService.getsadrzajKorisnikDislajkovao(idDTO.getId()), HttpStatus.OK);
    }

    /*@PostMapping(value="/createposts")
    public ResponseEntity<Sadrzaj> createpost(@RequestBody SadrzajDTO sadrzajDTO){
        return new ResponseEntity<>(sadrzajService.create(sadrzajDTO), HttpStatus.OK);
    }*/
    /*@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/upload")
    public ResponseEntity uploadFiles(@RequestParam("media") MultipartFile[] multipartFiles, HttpServletRequest request) {
        //String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
        String username = "v";
        return new ResponseEntity(sadrzajService.upload(multipartFiles, username), HttpStatus.CREATED);
    }*/

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/upload")
    public ResponseEntity uploadFiles(@RequestParam("media") MultipartFile multipartFiles, HttpServletRequest request) throws IOException {
        return new ResponseEntity(sadrzajService.upload(multipartFiles), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/getpictures")
    public ResponseEntity<Set<SadrzajReturnDTO>> getRegistrovaniKorisnikPictures(@RequestBody IdDTO idDTO){
        return new ResponseEntity<>(sadrzajService.getPictures(idDTO.getId()), HttpStatus.OK);

    }

}
