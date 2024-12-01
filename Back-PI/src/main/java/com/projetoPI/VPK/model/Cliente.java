package com.projetoPI.VPK.model;

import jakarta.persistence.*;
import com.projetoPI.VPK.model.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CLIENTES")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

    //private String endereco; //será possivelmente um objeto

    private String telefone;
    private String email;
    //@OneToOne
    //@JoinColumn(name = "user_id")
    //private User user;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente() {}

    public Cliente(String nome, String cpf, String telefone, String email, User user) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        //this.user = user;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   // public User getUser() {
        //return user;
  //  }

    //public void setUser(User user) {
        //this.user = user;
    //}





}
