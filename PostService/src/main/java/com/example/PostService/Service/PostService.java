package com.example.PostService.Service;

import com.example.PostService.Model.Post;
import com.example.PostService.Model.RegistrovaniKorisnik;
import com.example.PostService.Model.Sadrzaj;
import com.example.PostService.Model.Slika;
import com.example.PostService.Repository.LokacijaRepository;
import com.example.PostService.Repository.PostRepository;
import com.example.PostService.Repository.RegistrovaniKorisnikRepository;
import com.example.PostService.Repository.SlikaRepository;
import com.example.PostService.dto.RegistrovaniKorisnikDto;
import com.example.PostService.dto.SadrzajDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PostService {
    private PostRepository postRepository;
    private RegistrovaniKorisnikRepository registrovaniKorisnikRepository;
    private LokacijaRepository lokacijaRepository;
    private SlikaRepository slikaRepository;

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Autowired
    public RegistrovaniKorisnikRepository setRegistrovaniKorisnikRepository(RegistrovaniKorisnikRepository registrovaniKorisnikRepository) { return this.registrovaniKorisnikRepository = registrovaniKorisnikRepository; }

    @Autowired
    public LokacijaRepository setLokacijaRepository(LokacijaRepository lokacijaRepository) { return this.lokacijaRepository = lokacijaRepository; }

    @Autowired
    public SlikaRepository setSlikaRepository(SlikaRepository slikaRepository) { return this.slikaRepository = slikaRepository; }

    /*public Set<Post> findallbyregistrovanikorisnik(RegistrovaniKorisnik registrovanikorisnik){
        return postRepository.findAllByRegistrovaniKorisnik(registrovanikorisnik);
    }*/

    public Post create(SadrzajDTO sadrzajDTO) {
        Post sadrzaj = new Post();
        sadrzaj.setKreator(registrovaniKorisnikRepository.findOneById(sadrzajDTO.getUserId()));
        sadrzaj.setLokacija(lokacijaRepository.findByNaziv(sadrzajDTO.getLokacija()));
        Set<Slika> slike1 = new HashSet<>();
        for (String slika : sadrzajDTO.getSlike()) {
            Slika slika1 = new Slika();
            slika1.setUrl(slika);
            slike1.add(slika1);
        }


        sadrzaj.setSlike(slike1);

        sadrzaj = postRepository.save(sadrzaj);
        for (Slika slika : sadrzaj.getSlike()) {
            slika.setSadrzaj(sadrzaj);
            slikaRepository.save(slika);
        }
        return sadrzaj;
    }
}
