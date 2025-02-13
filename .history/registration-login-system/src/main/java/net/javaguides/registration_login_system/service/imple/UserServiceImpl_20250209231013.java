package net.javaguides.registration_login_system.service.imple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    // private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
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

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Userdto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> mapToUserDto(user)).collect(Collectors.toList());
    }

    private Userdto mapToUserDto(User user) {
        Userdto userdto = new Userdto();
        String[] str = user.getName().split(" ", 2);
        userdto.setFirstName(str[0]);
        userdto.setLastName(str[1]);
        userdto.setEmail(user.getEmail());
        return userdto;
    }

    private Role checkRoleExit() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

}
