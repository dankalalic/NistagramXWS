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

    public List<Sadrzaj> findByProfil(String username) {
        RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikRepository.findOneByUsername(username);
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

    public Sadrzaj like(Integer id, Integer userId) {
        Sadrzaj sadrzaj = sadrzajRepository.findOneById(id);
        RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikRepository.findOneById(userId);

        Set<RegistrovaniKorisnik> lajkovali = sadrzaj.getLajkovali();
        Set<RegistrovaniKorisnik> dislajkovali = sadrzaj.getDislajkovali();

        lajkovali.add(registrovaniKorisnik);

        dislajkovali.remove(registrovaniKorisnik);
        sadrzaj.setLajkovali(lajkovali);
        sadrzaj.setDislajkovali(dislajkovali);

        Set<Sadrzaj> lajkovano = registrovaniKorisnik.getSadrzajlajkovani();
        Set<Sadrzaj> dislajkovano = registrovaniKorisnik.getDislajkovan();

        lajkovano.add(sadrzaj);
        dislajkovano.remove(sadrzaj);

        registrovaniKorisnik.setSadrzajlajkovani(lajkovano);
        registrovaniKorisnik.setDislajkovan(dislajkovano);

        registrovaniKorisnikRepository.save(registrovaniKorisnik);

        /*if(sadrzaj.getDislajkovali().contains(registrovaniKorisnik)) {
            dislajkovali.remove(registrovaniKorisnik);
        }

        sadrzaj.setLajkovali(lajkovali);
        sadrzaj.setDislajkovali(dislajkovali);

        this.sadrzajRepository.saveAndFlush(sadrzaj);*/

        return sadrzajRepository.save(sadrzaj);
    }

    public Sadrzaj dislike(Integer id, Integer userId) {
        Sadrzaj sadrzaj = sadrzajRepository.findOneById(id);
        RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikRepository.findOneById(userId);
        Set<RegistrovaniKorisnik> lajkovali = sadrzaj.getLajkovali();
        Set<RegistrovaniKorisnik> dislajkovali = sadrzaj.getDislajkovali();

        lajkovali.remove(registrovaniKorisnik);
        dislajkovali.add(registrovaniKorisnik);
        sadrzaj.setDislajkovali(dislajkovali);
        sadrzaj.setLajkovali(lajkovali);

        Set<Sadrzaj> lajkovano = registrovaniKorisnik.getSadrzajlajkovani();
        Set<Sadrzaj> dislajkovano = registrovaniKorisnik.getDislajkovan();

        lajkovano.remove(sadrzaj);
        dislajkovano.add(sadrzaj);

        registrovaniKorisnik.setSadrzajlajkovani(lajkovano);
        registrovaniKorisnik.setDislajkovan(dislajkovano);

        registrovaniKorisnikRepository.save(registrovaniKorisnik);

        return sadrzajRepository.save(sadrzaj);
    }

    public String prijaviNeprikladanSadrzaj(IdDTO sadrzajDTO) {
        Sadrzaj sadrzaj = sadrzajRepository.findOneById(sadrzajDTO.getId());
        sadrzaj.setBrojreportova(sadrzaj.getBrojreportova() + 1);
        sadrzajRepository.save(sadrzaj);
        String s = "Uspesno ste prijavili neprikladan sadrzaj";
        return s;
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
            if(post.getUklonjeno().equals(false)){
                SadrzajReturnDTO sadrzajReturnDTO = new SadrzajReturnDTO(post.getId(), post.getKreator(),
                        post.getBrojreportova(), post.getLajkovali(), post.getDislajkovali(), post.getLokacija(),
                        post.getSlike(), post.getTagovi());
                sadrzajReturnDTOS.add(sadrzajReturnDTO);
            }
        }

        //dodaj reklame kasnije
        return sadrzajReturnDTOS;
    }

    public Set<SadrzajReturnDTO> getsadrzajKorisnikLajkovao(Integer id){
        RegistrovaniKorisnik registrovaniKorisnik=registrovaniKorisnikRepository.findOneById(id);
        Set<SadrzajReturnDTO> sadrzajReturnDTOS = new HashSet<>();
        List<Post> posts = postRepository.findAll();
        for (Post post: posts) {
            if(post.getLajkovali().contains(registrovaniKorisnik) && post.getUklonjeno().equals(false)){
                SadrzajReturnDTO sadrzajReturnDTO = new SadrzajReturnDTO(post.getId(), post.getKreator(),
                        post.getBrojreportova(), post.getLajkovali(), post.getDislajkovali(), post.getLokacija(),
                        post.getSlike(), post.getTagovi());
                sadrzajReturnDTOS.add(sadrzajReturnDTO);
            }
        }

        return sadrzajReturnDTOS;

    }

    public Set<SadrzajReturnDTO> getsadrzajKorisnikDislajkovao(Integer id){
        RegistrovaniKorisnik registrovaniKorisnik=registrovaniKorisnikRepository.findOneById(id);
        Set<SadrzajReturnDTO> sadrzajReturnDTOS = new HashSet<>();
        List<Post> posts = postRepository.findAll();
        for (Post post: posts) {
            if(post.getDislajkovali().contains(registrovaniKorisnik) && post.getUklonjeno().equals(false)){
                SadrzajReturnDTO sadrzajReturnDTO = new SadrzajReturnDTO(post.getId(), post.getKreator(),
                        post.getBrojreportova(), post.getLajkovali(), post.getDislajkovali(), post.getLokacija(),
                        post.getSlike(), post.getTagovi());
                sadrzajReturnDTOS.add(sadrzajReturnDTO);
            }
        }

        return sadrzajReturnDTOS;

    }

    public List<Sadrzaj> getAll() {
        List<Sadrzaj> sadrzajs = sadrzajRepository.findByUklonjeno(false);
        //dodaj reklame kasnije
        /*for (Sadrzaj s : sadrzajs) {
            if(s.getUklonjeno().equals(true)){
                sadrzajs.remove(s);
            }
        }*/
        return sadrzajs;

    }



}
