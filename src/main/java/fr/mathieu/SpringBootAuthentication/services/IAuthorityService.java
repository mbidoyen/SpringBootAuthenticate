package fr.mathieu.SpringBootAuthentication.services;

import java.util.Optional;
import java.util.Set;
import fr.mathieu.SpringBootAuthentication.models.entities.Authority;

public interface IAuthorityService {
    Optional<Authority> getAuthorityByRolename(String rolename);

    Set<Authority> getAllAuthorities();
}
