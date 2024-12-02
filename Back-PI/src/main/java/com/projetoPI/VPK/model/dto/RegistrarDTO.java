package com.projetoPI.VPK.model.dto;


import com.projetoPI.VPK.model.enums.RoleUsers;

public record RegistrarDTO(String email, String senha, String CPF , String telefone, RoleUsers role, String nome) {
}
