package com.projetoPI.VPK.model;

import com.projetoPI.VPK.model.Enum.Disponibilidade;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_ENTREGADOR")
public class Entregador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    //private String cpf;

    @Enumerated(EnumType.STRING)
    private Disponibilidade disponibilidade;

    @OneToMany(mappedBy = "entregador")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "entregador")
    private List<Rota> rotas;

    public Entregador() {
    }

    public Entregador(Long id, String nome, Disponibilidade disponibilidade, List<Pedido> pedidos, List<Rota> rotas) {
        this.id = id;
        this.nome = nome;
        this.disponibilidade = disponibilidade;
        this.pedidos = pedidos;
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

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(List<Rota> rotas) {
        this.rotas = rotas;
    }
}
