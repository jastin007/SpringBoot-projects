package net.javaguides.registration_login_system.Security;

import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}
