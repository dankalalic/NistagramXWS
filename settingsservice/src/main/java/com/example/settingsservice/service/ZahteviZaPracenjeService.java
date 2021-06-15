package com.example.settingsservice.service;

import com.example.settingsservice.model.ZahteviZaPracenje;
import com.example.settingsservice.repository.ZahteviZaPracenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZahteviZaPracenjeService {

    @Autowired
    private ZahteviZaPracenjeRepository zahteviZaPracenjeRepository;

    public ZahteviZaPracenje save(ZahteviZaPracenje zahteviZaPracenje){

       ZahteviZaPracenje zahteviZaPracenje1= new ZahteviZaPracenje();
       zahteviZaPracenje1=zahteviZaPracenjeRepository.save(zahteviZaPracenje);
       return  zahteviZaPracenje1;
    }
}
