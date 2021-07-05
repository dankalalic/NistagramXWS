package com.example.CampaignService.model;

import org.springframework.web.multipart.MultipartFile;

public class ReklamaDTO {
    private Slika slika;
    private String url;

    public ReklamaDTO() {
    }

    public ReklamaDTO(Slika slika, String url) {
        this.slika = slika;
        this.url = url;
    }

    public Slika getSlika() {
        return slika;
    }

    public void setSlika(Slika slika) {
        this.slika = slika;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
