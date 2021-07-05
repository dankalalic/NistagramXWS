package com.example.CampaignService.model;

import org.springframework.web.multipart.MultipartFile;

public class ReklamaDTO {
    private MultipartFile slika;
    private String url;

    public ReklamaDTO() {
    }

    public ReklamaDTO(MultipartFile slika, String url) {
        this.slika = slika;
        this.url = url;
    }

    public MultipartFile getSlika() {
        return slika;
    }

    public void setSlika(MultipartFile slika) {
        this.slika = slika;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
