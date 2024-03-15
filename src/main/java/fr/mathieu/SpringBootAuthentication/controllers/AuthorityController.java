package fr.mathieu.SpringBootAuthentication.controllers;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import fr.mathieu.SpringBootAuthentication.models.dtos.authorityDTO.RoleDto;
import fr.mathieu.SpringBootAuthentication.models.entities.Authority;
import fr.mathieu.SpringBootAuthentication.services.IAuthorityService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AuthorityController {

    @Autowired
    private IAuthorityService authorityService;

    @GetMapping("/authority")
    public ResponseEntity<Set<RoleDto>> getAllAuthorities() {
        Set<Authority> authorities = authorityService.getAllAuthorities();
        Set<RoleDto> roles = authorities.stream()
                .map(role -> new RoleDto(role.getId(), role.getRolename()))
                .collect(Collectors.toSet());
        return ResponseEntity.ok().body(roles);
    }

}
