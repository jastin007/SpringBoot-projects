package net.javaguides.registration_login_system.service.imple;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import net.javaguides.registration_login_system.Entity.Role;
import net.javaguides.registration_login_system.Entity.User;
import net.javaguides.registration_login_system.dto.Userdto;
import net.javaguides.registration_login_system.repository.RoleRepository;
import net.javaguides.registration_login_system.repository.UserRepository;
import net.javaguides.registration_login_system.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(Userdto userdto) {
        User user = new User();
        user.setName(userdto.getFirstName() + " " + userdto.getLastName());
        user.setEmail(userdto.getEmail());
        // encrypt the password using spring security
        user.setPassword(userdto.getPassword());

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null) {
            role = checkRoleExit();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    private Role checkRoleExit() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
