package net.javaguides.registration_login_system.service.imple;

import org.springframework.stereotype.Service;

import net.javaguides.registration_login_system.Entity.User;
import net.javaguides.registration_login_system.dto.Userdto;
import net.javaguides.registration_login_system.repository.RoleRepository;
import net.javaguides.registration_login_system.repository.UserRepository;
import net.javaguides.registration_login_system.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(Userdto userdto) {
        User user = new User();
        user.setName(userdto.getFirstName() + " " + userdto.getLastName());
        user.setEmail(userdto.getEmail());
        // encrypt the password using spring security
        user.setPassword(userdto.getPassword());
    }

}
