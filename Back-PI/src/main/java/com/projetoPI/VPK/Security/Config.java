package com.projetoPI.VPK.Security;

import com.projetoPI.VPK.services.InitBaseDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Config {
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;
    @Autowired
    private InitBaseDBService dbService;
    @Bean
    public Boolean InstanciaDB(){
        if (value.equals("create-drop")){
            this.dbService.InstanciaDB();
        }
        return false;
    }
}


