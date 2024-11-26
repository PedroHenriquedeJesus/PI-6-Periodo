package com.projetoPI.VPK;



import com.projetoPI.VPK.model.User;
import com.projetoPI.VPK.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class StartApplication implements CommandLineRunner {

    @Autowired
    private IUserRepository repository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        // Criação do usuário admin
        createUserIfNotExists("admin", "ADMIN", "123", "ADMIN");

        // Criação do usuário user
        createUserIfNotExists("user", "USER", "123", "USER");
    }

    private void createUserIfNotExists(String username, String name, String password, String role) {
        Optional<User> optionalUser = repository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            User user = new User();
            user.setUsername(name);
            user.setUsername(username);
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            user.getRoles().add(role);
            repository.save(user);
        }
    }
}