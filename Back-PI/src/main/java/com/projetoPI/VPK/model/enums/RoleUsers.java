package com.projetoPI.VPK.model.enums;

public enum RoleUsers {
    admin("admin"),
    user("user");

    private String role;

    RoleUsers(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
