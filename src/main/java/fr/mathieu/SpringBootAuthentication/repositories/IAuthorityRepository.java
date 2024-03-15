package fr.mathieu.SpringBootAuthentication.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.mathieu.SpringBootAuthentication.models.entities.Authority;
import org.springframework.lang.NonNull;

@Repository
public interface IAuthorityRepository extends JpaRepository<Authority, UUID> {
    Optional<Authority> findByRolename(String rolename);

    @NonNull
    List<Authority> findAll();
}
