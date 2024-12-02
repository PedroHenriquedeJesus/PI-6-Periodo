package com.projetoPI.VPK.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_rota")
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String NomeEndereco;
    private Double latitude;
    private Double longitude;
    private Integer numeroSequencial;

    @ManyToOne
    @JoinColumn(name = "entregador_id")
    private Entregador entregador;


    public Rota() {
    }

    public Rota(Long id, String nomeEndereco, Double latitude, Double longitude, Integer numeroSequencial, Entregador entregador) {
        this.id = id;
        NomeEndereco = nomeEndereco;
        this.latitude = latitude;
        this.longitude = longitude;
        this.numeroSequencial = numeroSequencial;
        this.entregador = entregador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEndereco() {
        return NomeEndereco;
    }

    public void setNomeEndereco(String nomeEndereco) {
        NomeEndereco = nomeEndereco;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getNumeroSequencial() {
        return numeroSequencial;
    }

    public void setNumeroSequencial(Integer numeroSequencial) {
        this.numeroSequencial = numeroSequencial;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }
}
