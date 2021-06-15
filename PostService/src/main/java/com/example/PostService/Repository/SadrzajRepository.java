package com.example.PostService.Repository;

import com.example.PostService.Model.Lokacija;
import com.example.PostService.Model.RegistrovaniKorisnik;
import com.example.PostService.Model.Sadrzaj;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SadrzajRepository extends JpaRepository<Sadrzaj, Integer> {
    List<Sadrzaj> findByLokacija(Lokacija lokacija);

    List<Sadrzaj> findByKreator(RegistrovaniKorisnik registrovaniKorisnik);

    Sadrzaj findOneById(Integer id);
}
