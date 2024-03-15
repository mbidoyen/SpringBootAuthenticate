package fr.mathieu.SpringBootAuthentication.services.impl;

import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mathieu.SpringBootAuthentication.models.entities.Authority;
import fr.mathieu.SpringBootAuthentication.repositories.IAuthorityRepository;
import fr.mathieu.SpringBootAuthentication.services.IAuthorityService;

@Service
public class AuthorityServiceIMPL implements IAuthorityService {

    @Autowired
    private IAuthorityRepository authorityRepository;

    @Override
    public Optional<Authority> getAuthorityByRolename(String rolename) {
        return authorityRepository.findByRolename(rolename);
    }

    @Override
    public Set<Authority> getAllAuthorities() {
        return new HashSet<>(authorityRepository.findAll());
    }

}
