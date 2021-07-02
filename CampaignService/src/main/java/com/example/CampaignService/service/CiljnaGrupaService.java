package com.example.CampaignService.service;

import com.example.CampaignService.repository.CiljnaGrupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiljnaGrupaService {

    @Autowired
    private CiljnaGrupaRepository ciljnaGrupaRepository;
}
