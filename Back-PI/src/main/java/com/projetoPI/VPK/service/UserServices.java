package com.projetoPI.VPK.service;

import com.projetoPI.VPK.model.User;
import com.projetoPI.VPK.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private IUserRepository iuserrepository;

    public Optional<User> findByUsername(String username) {return iuserrepository.findByUsername(username);}
    public User save(User user) {return iuserrepository.save(user);}
    public User findByUsernameAndPassword(User user) {
        return this.iuserrepository.findByUsernameAndPassword(user.getUsername(),user.getPassword()).orElseThrow(()-> new UsernameNotFoundException(user.getUsername()));
    }


}
