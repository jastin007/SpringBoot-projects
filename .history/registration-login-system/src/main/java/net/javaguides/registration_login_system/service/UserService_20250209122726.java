package net.javaguides.registration_login_system.service;

import net.javaguides.registration_login_system.Entity.User;
import net.javaguides.registration_login_system.dto.Userdto;

public interface UserService {
    void saveUser(Userdto userdto);

    User findUserByEmail(String email);
}
