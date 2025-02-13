package net.javaguides.registration_login_system.dto;

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
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
