package net.javaguides.registration_login_system.Security;

import org.springframework.security.core.userdetails.UserDetails;

import net.javaguides.registration_login_system.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}
