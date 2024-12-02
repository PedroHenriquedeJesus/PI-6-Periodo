package com.projetoPI.VPK.model;

import com.projetoPI.VPK.model.enums.Disponibilidade;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_entregador")
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String placa;
    @Enumerated(EnumType.STRING)
    private Disponibilidade disponibilidade;
    private Integer capacidade ;



    @OneToMany(mappedBy = "entregador")
    private List<Rota> rotas;

    public Entregador(Long id, String nome, String placa, Disponibilidade disponibilidade, Integer capacidade) {
        this.id = id;
        this.nome = nome;
        this.placa = placa;
        this.disponibilidade = disponibilidade;
        this.capacidade = capacidade;
    }


    public Entregador() {
    }

    public Entregador(Long id, String nome, String placa, Disponibilidade disponibilidade, Integer capacidade, List<Rota> rotas) {
        this.id = id;
        this.nome = nome;
        this.placa = placa;
        this.disponibilidade = disponibilidade;
        this.capacidade = capacidade;
        this.rotas = rotas;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public List<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(List<Rota> rotas) {
        this.rotas = rotas;
    }
}
