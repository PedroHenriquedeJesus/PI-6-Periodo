package com.projetoPI.VPK.model;

import com.projetoPI.VPK.model.enums.StatusDoCarrinho;
import jakarta.persistence.*;


import java.util.Objects;

@Entity
@Table(name = "tb_carrinho")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Cliente usuario;

    @Column(name = "status")
    private StatusDoCarrinho status;

    public Carrinho() {
    }


    public Carrinho(Long id, Cliente usuario, StatusDoCarrinho status) {
        this.id = id;
        this.usuario = usuario;
        this.status = status;
    }


    public StatusDoCarrinho getStatus() {
        return status;
    }

    public void setStatus(StatusDoCarrinho status) {
        this.status = status;
    }

    public Cliente getUsuario() {
        return usuario;
    }

    public void setUsuario(Cliente usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrinho carrinho = (Carrinho) o;
        return Objects.equals(id, carrinho.id) && Objects.equals(usuario, carrinho.usuario) && status == carrinho.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, status);
    }


    @Override
    public String toString() {
        return "Carrinho{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", status=" + status +
                '}';
    }
}