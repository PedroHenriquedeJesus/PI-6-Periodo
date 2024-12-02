package com.projetoPI.VPK.services;
import com.projetoPI.VPK.model.*;
import com.projetoPI.VPK.model.dto.UserDTO;
import com.projetoPI.VPK.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).get();
        return new UserDTO(user);
    }

    public User findCompletUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }



    public List<UserDTO> findAll() {
        List<User> result = userRepository.findAll();
        return result.stream().map(x -> new UserDTO(x)).toList();
    }
}
