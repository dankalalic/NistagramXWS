package com.example.AgentApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Slika {

    @Id
    @SequenceGenerator(name = "seq_slika", sequenceName = "seq_slika", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_slika")
    private Integer id;

    @Column
    private String name;

    @Lob
    @Column
    private byte[] url;

    @Column
    private Long size;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Proizvod proizvod;

    public Slika(String name, byte[] url, Long size) {
        this.name = name;
        this.url = url;
        this.size = size;
    }
    public Slika() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getUrl() {
        return url;
    }

    public void setUrl(byte[] url) {
        this.url = url;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
