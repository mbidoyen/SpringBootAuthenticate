package fr.mathieu.SpringBootAuthentication.controllers;

import org.springframework.web.bind.annotation.RestController;

import fr.mathieu.SpringBootAuthentication.models.dtos.AuthenticateUserDto;
import fr.mathieu.SpringBootAuthentication.models.dtos.RegisterUserDto;
import fr.mathieu.SpringBootAuthentication.models.entities.Authority;
import fr.mathieu.SpringBootAuthentication.models.entities.User;
import fr.mathieu.SpringBootAuthentication.security.AuthorityConstant;
import fr.mathieu.SpringBootAuthentication.services.IAuthorityService;
import fr.mathieu.SpringBootAuthentication.services.IUserService;
import fr.mathieu.SpringBootAuthentication.utils.LoggerUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
public class AuthenticateController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAuthorityService authorityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/user/{uuid}")
    public ResponseEntity<UUID> getOneUser(@PathVariable("uuid") UUID uuid) {
        log.info("récupération de l'utilisateur : " + uuid);
        return ResponseEntity.ok().body(uuid);
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@Valid @RequestBody RegisterUserDto registerUserDto) {
        User user = User.builder()
                .email(registerUserDto.getEmail())
                .password(passwordEncoder.encode(registerUserDto.getPassword()))
                .build();

        Optional<Authority> authority = authorityService.getAuthorityByRolename(AuthorityConstant.ROLE_USER);
        if (authority.isPresent()) {
            Set<Authority> authorities = new HashSet<>();
            authorities.add(authority.get());
            user.setAuthorities(authorities);
            user.setEnabled(true);
            try {
                UUID uuid = userService.save(user);
                if (uuid != null) {
                    LoggerUtil.logSuccess("User registration was successful");
                    return ResponseEntity.ok().body(true);
                } else {
                    log.error("User registration failed - save operation returned null UUID");
                    return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } catch (DataIntegrityViolationException ex) {
                log.error("Data integrity violation during user registration");
                return new ResponseEntity<>(false, HttpStatus.CONFLICT);
            } catch (Exception e) {
                log.error("Error occurred during user registration");
                return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            log.error("Default role not found.");
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> postMethodName(@RequestBody AuthenticateUserDto user) {
        log.info("Authentification de l'utilisateur : ");
        return new ResponseEntity<>("Welcome, Login", HttpStatus.OK);
    }

}
