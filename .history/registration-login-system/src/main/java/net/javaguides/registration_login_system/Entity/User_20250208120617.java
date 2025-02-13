package net.javaguides.registration_login_system.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
}
