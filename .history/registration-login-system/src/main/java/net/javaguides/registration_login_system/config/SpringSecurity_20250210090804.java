package net.javaguides.registration_login_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    // configure securityFilterchain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and()
                .formLogin(
                        form -> form.loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/users")
                                .permitAll());
        return http.build();
    }
}
