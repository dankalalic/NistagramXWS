package com.example.settingsservice.controller;

import com.example.settingsservice.service.KategorijaProfilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kategorijeProfila")
public class KategorijaProfilaController {

    @Autowired
    private KategorijaProfilaService kategorijaProfilaService;
}
