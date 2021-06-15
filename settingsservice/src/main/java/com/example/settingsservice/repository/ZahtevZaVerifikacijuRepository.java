package com.example.settingsservice.repository;

import com.example.settingsservice.model.ZahtevZaVerifikaciju;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZahtevZaVerifikacijuRepository extends JpaRepository<ZahtevZaVerifikaciju, Integer> {
}
