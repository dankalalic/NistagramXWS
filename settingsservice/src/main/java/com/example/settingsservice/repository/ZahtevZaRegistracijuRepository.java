package com.example.settingsservice.repository;

import com.example.settingsservice.model.RegisteredUser;
import com.example.settingsservice.model.ZahtevZaRegistraciju;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZahtevZaRegistracijuRepository extends JpaRepository<ZahtevZaRegistraciju, Integer> {

    ZahtevZaRegistraciju findOneByRegisteredUser(RegisteredUser registeredUser);
}
