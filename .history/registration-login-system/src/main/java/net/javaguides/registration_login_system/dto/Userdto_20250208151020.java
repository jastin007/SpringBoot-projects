package net.javaguides.registration_login_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Userdto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
