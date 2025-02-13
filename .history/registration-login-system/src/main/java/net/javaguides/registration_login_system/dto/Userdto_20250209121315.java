package net.javaguides.registration_login_system.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Userdto {
    private Long id;
    @NotEmpty
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
