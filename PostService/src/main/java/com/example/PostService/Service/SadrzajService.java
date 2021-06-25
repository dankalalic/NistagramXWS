package com.example.PostService.Service;

import com.example.PostService.Model.RegistrovaniKorisnik;
import com.example.PostService.Model.Sadrzaj;
import com.example.PostService.Repository.SadrzajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PostService.Model.Lokacija;
import com.example.PostService.Model.Tagovi;
import com.example.PostService.Repository.LokacijaRepository;
import com.example.PostService.Repository.RegistrovaniKorisnikRepository;
import com.example.PostService.Repository.SadrzajRepository;
import com.example.PostService.Repository.TagRepository;
import com.example.PostService.Model.*;
import com.example.PostService.Repository.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import javax.persistence.Id;


@Service
public class SadrzajService {
    private SadrzajRepository sadrzajRepository;
    private LokacijaRepository lokacijaRepository;
    private TagRepository tagRepository;
    private RegistrovaniKorisnikRepository registrovaniKorisnikRepository;
    private PostRepository postRepository;
    private SlikaRepository slikaRepository;

    @Autowired
    public SadrzajRepository setSadrzajRepository(SadrzajRepository sadrzajRepository) { return this.sadrzajRepository = sadrzajRepository; }

    @Autowired
    public LokacijaRepository setLokacijaRepository(LokacijaRepository lokacijaRepository) { return this.lokacijaRepository = lokacijaRepository; }

    @Autowired
    public TagRepository setTagRepository(TagRepository tagRepository)
    {
        return this.tagRepository = tagRepository;
    }

    @Autowired
    public RegistrovaniKorisnikRepository setRegistrovaniKorisnikRepository(RegistrovaniKorisnikRepository registrovaniKorisnikRepository) { return this.registrovaniKorisnikRepository = registrovaniKorisnikRepository; }

    @Autowired
    public PostRepository setPostRepository(PostRepository postRepository) {return this.postRepository = postRepository; }

    @Autowired
    public SlikaRepository setSlikaRepository(SlikaRepository slikaRepository) { return this.slikaRepository = slikaRepository; }

    public List<Sadrzaj> findByLokacija(String lokacija) {
        Lokacija lokacija1 = lokacijaRepository.findByNaziv(lokacija);
        return sadrzajRepository.findByLokacija(lokacija1);
    }

    public List<Sadrzaj> findByTag(String tag) {
        Tagovi tagovi = tagRepository.findByNaziv(tag);
        List<Sadrzaj> sadrzaji = new ArrayList<>();
        sadrzaji.addAll(tagovi.getSadrzaj());

        return sadrzaji;
    }

    public List<Sadrzaj> findByProfil(Integer id) {
        RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikRepository.findOneById(id);
        List<Sadrzaj> sadrzajs = new ArrayList<>();

        /*Boolean isPrivate =
                new RestTemplate().postForObject(
                        "http://localhost:8082/follower/isPrivate", id, Boolean.class);
        if (isPrivate) {
            sadrzajs = sadrzajRepository.findByKreator(registrovaniKorisnik);
        } else {
            System.out.println("Profil je privatan!");
        }*/
        sadrzajs.addAll(postRepository.findByKreator(registrovaniKorisnik));
        //dodaj i reklame kad
        return sadrzajs;
    }

    public Sadrzaj like(SadrzajUserDTO sadrzajUserDTO) {
        Sadrzaj sadrzaj = sadrzajRepository.findOneById(sadrzajUserDTO.getSadrzajId());
        RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikRepository.findOneById(sadrzajUserDTO.getUserId());
        Set<RegistrovaniKorisnik> lajkovali = sadrzaj.getLajkovali();
        Set<RegistrovaniKorisnik> dislajkovali = sadrzaj.getDislajkovali();

        lajkovali.add(registrovaniKorisnik);
        dislajkovali.remove(registrovaniKorisnik);
        sadrzaj.setLajkovali(dislajkovali);
        sadrzaj.setDislajkovali(lajkovali);

        return sadrzajRepository.save(sadrzaj);
    }

    public Sadrzaj dislike(SadrzajUserDTO sadrzajUserDTO) {
        Sadrzaj sadrzaj = sadrzajRepository.findOneById(sadrzajUserDTO.getSadrzajId());
        RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikRepository.findOneById(sadrzajUserDTO.getUserId());
        Set<RegistrovaniKorisnik> lajkovali = sadrzaj.getLajkovali();
        Set<RegistrovaniKorisnik> dislajkovali = sadrzaj.getDislajkovali();

        lajkovali.remove(registrovaniKorisnik);
        dislajkovali.add(registrovaniKorisnik);
        sadrzaj.setDislajkovali(dislajkovali);
        sadrzaj.setLajkovali(lajkovali);

        return sadrzajRepository.save(sadrzaj);
    }

    public Sadrzaj prijaviNeprikladanSadrzaj(IdDTO sadrzajDTO) {
        Sadrzaj sadrzaj = sadrzajRepository.findOneById(sadrzajDTO.getId());
        sadrzaj.setBrojreportova(sadrzaj.getBrojreportova() + 1);
        return sadrzajRepository.save(sadrzaj);
    }
    /*public Sadrzaj create(SadrzajDTO sadrzajDTO) {
        Sadrzaj sadrzaj = new Sadrzaj();
        sadrzaj.setKreator(registrovaniKorisnikRepository.findOneById(sadrzajDTO.getUserId()));
        sadrzaj.setLokacija(lokacijaRepository.findByNaziv(sadrzajDTO.getLokacija()));
        Set<Slika> slike1 = new HashSet<>();
        for (String slika : sadrzajDTO.getSlike()) {
            Slika slika1 = new Slika();
            slika1.setUrl(slika);
            slike1.add(slika1);
        }


        sadrzaj.setSlike(slike1);

        sadrzaj = sadrzajRepository.save(sadrzaj);
        for (Slika slika : sadrzaj.getSlike()) {
            slika.setSadrzaj(sadrzaj);
        }
        return sadrzaj;
    }*/


    public Integer upload (MultipartFile multipartFile) throws IOException {
        try {
            String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            Slika slika = new Slika();
            slika.setName(filename);
            slika.setUrl(multipartFile.getBytes());
            slika.setSize(multipartFile.getSize());

            slika = slikaRepository.save(slika);
            return slika.getId();
        } catch(Exception e) {
            return null;
        }
    }

    public Set<SadrzajReturnDTO> getPictures(Integer id){
        RegistrovaniKorisnik registrovaniKorisnik=registrovaniKorisnikRepository.findOneById(id);
        Set<SadrzajReturnDTO> sadrzajReturnDTOS= new HashSet<>();
        for (Post post : registrovaniKorisnik.getPosts()) {
            SadrzajReturnDTO sadrzajReturnDTO = new SadrzajReturnDTO(post.getId(), post.getKreator(),
                    post.getBrojreportova(), post.getLajkovali(), post.getDislajkovali(), post.getLokacija(),
                    post.getSlike(), post.getTagovi());
            sadrzajReturnDTOS.add(sadrzajReturnDTO);
        }

        //dodaj reklame kasnije
        return sadrzajReturnDTOS;
    }
}
