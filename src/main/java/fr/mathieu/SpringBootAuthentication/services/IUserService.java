package fr.mathieu.SpringBootAuthentication.services;

import java.util.UUID;

import fr.mathieu.SpringBootAuthentication.models.dtos.UserDTO;
import fr.mathieu.SpringBootAuthentication.models.entities.User;

public interface IUserService {
    UUID save(User user);

    UserDTO findOneByEmail(String email);
}
