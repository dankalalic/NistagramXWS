package com.example.settingsservice.controller;

import com.example.settingsservice.service.ZahteviZaPracenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zahteviZaPracenje")
public class ZahteviZaPracenjeController {

    @Autowired
    private ZahteviZaPracenjeService zahteviZaPracenjeService;

}
