package com.example.settingsservice.repository;

import com.example.settingsservice.model.ZahtevZaVerifikaciju;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZahtevZaVerifikacijuRepository extends JpaRepository<ZahtevZaVerifikaciju, Integer> {

    List<ZahtevZaVerifikaciju> getAllByObradjen(Boolean status);
    ZahtevZaVerifikaciju  findOneById(Integer id);
}
