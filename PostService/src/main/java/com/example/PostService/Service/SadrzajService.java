package com.example.PostService.Service;

import com.example.PostService.Model.RegistrovaniKorisnik;
import com.example.PostService.Model.Sadrzaj;
import com.example.PostService.Repository.SadrzajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PostService.DTO.SadrzajUserDTO;
import com.example.PostService.Model.Lokacija;
import com.example.PostService.Model.Tagovi;
import com.example.PostService.Repository.LokacijaRepository;
import com.example.PostService.Repository.RegistrovaniKorisnikRepository;
import com.example.PostService.Repository.SadrzajRepository;
import com.example.PostService.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SadrzajService {
    private SadrzajRepository sadrzajRepository;

    private LokacijaRepository lokacijaRepository;
    private TagRepository tagRepository;
    private RegistrovaniKorisnikRepository registrovaniKorisnikRepository;

    @Autowired
    public SadrzajRepository setSadrzajRepository(SadrzajRepository sadrzajRepository)
    {
        return this.sadrzajRepository = sadrzajRepository;
    }

    @Autowired
    public LokacijaRepository setLokacijaRepository(LokacijaRepository lokacijaRepository)
    {
        return this.lokacijaRepository = lokacijaRepository;
    }

    @Autowired
    public TagRepository setTagRepository(TagRepository tagRepository)
    {
        return this.tagRepository = tagRepository;
    }

    @Autowired
    public RegistrovaniKorisnikRepository setRegistrovaniKorisnikRepository(RegistrovaniKorisnikRepository registrovaniKorisnikRepository)
    {
        return this.registrovaniKorisnikRepository = registrovaniKorisnikRepository;
    }


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
        List<Sadrzaj> sadrzajs = sadrzajRepository.findByKreator(registrovaniKorisnik);
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
}
