package fr.mathieu.SpringBootAuthentication.models.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthenticationResponse {
    private String token;
    private String username;
}
