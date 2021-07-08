package com.example.PostService.Controller;

import com.example.PostService.Model.RegistrovaniKorisnik;
import com.example.PostService.Model.RegistrovaniKorisnikDTO;
import com.example.PostService.Repository.RegistrovaniKorisnikRepository;
import com.example.PostService.Service.RegistrovaniKorisnikService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/registrovanikorisnik")
public class RegistrovaniKorisnikController {
    private RegistrovaniKorisnikService registrovaniKorisnikService;

    private RegistrovaniKorisnikRepository registrovaniKorisnikRepository;

    @Autowired
    public void setRegistrovaniKorisnikRepository(RegistrovaniKorisnikRepository registrovaniKorisnikRepository) {
        this.registrovaniKorisnikRepository = registrovaniKorisnikRepository;
    }

    @Autowired
    public void setRegistrovaniKorisnikService(RegistrovaniKorisnikService registrovaniKorisnikService) {
        this.registrovaniKorisnikService = registrovaniKorisnikService;
    }


    @PostMapping(value="/adduser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Boolean addUser(@RequestBody RegistrovaniKorisnikDTO idDoubleDTO) {
        RegistrovaniKorisnik user = new RegistrovaniKorisnik();
        user.setId(idDoubleDTO.getId());
        user.setUsername(idDoubleDTO.getUsername());
        registrovaniKorisnikRepository.save(user);

        return true;

    }
}
