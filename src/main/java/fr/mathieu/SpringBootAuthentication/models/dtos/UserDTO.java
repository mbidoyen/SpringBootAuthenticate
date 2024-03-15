package fr.mathieu.SpringBootAuthentication.models.dtos;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {

    private UUID id;

    private String email;

    private List<String> authorities;
}
