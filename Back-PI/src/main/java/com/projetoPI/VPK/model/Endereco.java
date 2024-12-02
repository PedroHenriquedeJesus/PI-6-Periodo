package com.projetoPI.VPK.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String descricao;
    private String cep;
    private String complemento;
    private Integer numero;

    @OneToMany(mappedBy = "endereco")
    @JsonManagedReference  // Evita o loop, serializa a lista de pedidos
    private List<Pedido> pedidos;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Endereco() {
    }

    public Endereco(Long id, String rua, String descricao, String cep, String complemento, Integer numero, List<Pedido> pedidos, User user) {
        this.id = id;
        this.rua = rua;
        this.descricao = descricao;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
        this.pedidos = pedidos;
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
