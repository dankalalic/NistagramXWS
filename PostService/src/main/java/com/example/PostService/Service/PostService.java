package com.example.PostService.Service;

import com.example.PostService.Model.*;
import com.example.PostService.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostService {
    private PostRepository postRepository;
    private RegistrovaniKorisnikRepository registrovaniKorisnikRepository;
    private LokacijaRepository lokacijaRepository;
    private SlikaRepository slikaRepository;
    private TagRepository tagoviRepository;

    @Autowired
    private SadrzajRepository sadrzajRepository;

    @Autowired
    public void setTagoviRepository(TagRepository tagoviRepository) {
        this.tagoviRepository = tagoviRepository;
    }

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    /*public Set<Post> findallbyregistrovanikorisnik(RegistrovaniKorisnik registrovanikorisnik){
        return postRepository.findAllByRegistrovaniKorisnik(registrovanikorisnik);
    }*/

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
        sadrzaj.setTagovi(tagoviRepository.findAllByNaziv(sadrzajDTO.getTag()));
        sadrzaj.setUklonjeno(false);
        sadrzaj.setBrojreportova(0);
        sadrzaj.setReklama(false);
        Set<Slika> slike1 = new HashSet<>();
        for (Integer slika : sadrzajDTO.getSlike()) {
            Slika slika1 = slikaRepository.findOneById(slika);
            slike1.add(slika1);
        }
        sadrzaj.setSlike(slike1);

        sadrzaj = postRepository.save(sadrzaj);
        for (Integer slika : sadrzajDTO.getSlike()) {
            Slika slika1 = slikaRepository.findOneById(slika);
            slika1.setSadrzaj(sadrzaj);
            slikaRepository.save(slika1);
        }


        return sadrzaj;
    }

    public Set<SadrzajReturnDTO> PregledNeprikladnogSadrzaja(){
        List<Post> posts = postRepository.findAll();

        Set<SadrzajReturnDTO> sadrzajReturnDTOS = new HashSet<>();

        for (Post p : posts) {
            if (p.getBrojreportova() != 0 && p.getUklonjeno().equals(false)){
                SadrzajReturnDTO sadrzajReturnDTO = new SadrzajReturnDTO(p.getId(), p.getKreator(), p.getBrojreportova(), p.getLajkovali(), p.getDislajkovali(), p.getLokacija(), p.getSlike(), p.getTagovi());
                sadrzajReturnDTOS.add(sadrzajReturnDTO);
            }
        }

        return sadrzajReturnDTOS;

    }

    public StringDTO ukloni(IdDTO idDTO){
        Post post = postRepository.findOneById(idDTO.getId());
        post.setUklonjeno(true);
        postRepository.save(post);
        String s = "Uspesno ste uklonili sadrzaj";
        StringDTO stringDTO = new StringDTO(s);
        return stringDTO;
    }

    public Boolean ugasiSvePostoveUsera(String username){
        RegistrovaniKorisnik registrovaniKorisnik = registrovaniKorisnikRepository.findOneByUsername(username);
        List<Post> posts = postRepository.findByKreator(registrovaniKorisnik);

        for (Post p: posts) {
            p.setUklonjeno(true);
            postRepository.save(p);
        }

        return true;
    }

}
