package fr.mathieu.SpringBootAuthentication.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.mathieu.SpringBootAuthentication.models.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
