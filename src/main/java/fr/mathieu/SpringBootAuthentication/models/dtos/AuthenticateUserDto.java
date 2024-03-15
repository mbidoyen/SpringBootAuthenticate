package fr.mathieu.SpringBootAuthentication.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AuthenticateUserDto {

    @JsonProperty("_email")
    private String email;

    @JsonProperty("_password")
    private String password;
}
