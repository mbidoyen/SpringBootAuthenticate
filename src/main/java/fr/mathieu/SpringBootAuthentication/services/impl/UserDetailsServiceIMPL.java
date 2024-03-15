package fr.mathieu.SpringBootAuthentication.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.mathieu.SpringBootAuthentication.models.entities.User;
import fr.mathieu.SpringBootAuthentication.repositories.IUserRepository;

@Service
public class UserDetailsServiceIMPL implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email : " + email);
        }

        if (!user.getEnabled()) {
            throw new DisabledException("User account is disabled");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                user.getAuthorities());
    }

}
