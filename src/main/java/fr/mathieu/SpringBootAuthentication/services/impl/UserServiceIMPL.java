package fr.mathieu.SpringBootAuthentication.services.impl;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mathieu.SpringBootAuthentication.models.dtos.UserDTO;
import fr.mathieu.SpringBootAuthentication.models.entities.User;
import fr.mathieu.SpringBootAuthentication.repositories.IUserRepository;
import fr.mathieu.SpringBootAuthentication.services.IUserService;
import lombok.NonNull;

@Service
public class UserServiceIMPL implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UUID save(@NonNull User user) {
        return this.userRepository.save(user).getId();
    }

    @Override
    public UserDTO findOneByEmail(String email) {

        throw new UnsupportedOperationException("Unimplemented method 'findOneByEmail'");
    }

}
