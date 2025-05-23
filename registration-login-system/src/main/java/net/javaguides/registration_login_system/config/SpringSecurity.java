package net.javaguides.registration_login_system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

        @Autowired
        private UserDetailsService userDetailsService;

        @Bean
        public static PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        // configure securityFilterchain
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                // http.csrf().disable().authorizeRequests().anyRequest().authenticated().and()
                // .formLogin(
                // form -> form.loginPage("/login")
                // .loginProcessingUrl("/login")
                // .defaultSuccessUrl("/user")
                // .permitAll())
                // .logout(
                // logout -> logout
                // .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());

                http.csrf().disable().authorizeRequests().requestMatchers("/register/**").permitAll()
                                .requestMatchers("/index").permitAll()
                                .requestMatchers("/user").hasRole("ADMIN")
                                .and()
                                .formLogin(
                                                form -> form
                                                                .loginPage("/login")
                                                                .loginProcessingUrl("/login")
                                                                .defaultSuccessUrl("/user")
                                                                .permitAll())
                                .logout(
                                                logout -> logout.logoutRequestMatcher(
                                                                new AntPathRequestMatcher("/logout"))
                                                                .permitAll());
                return http.build();

        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
                builder.userDetailsService(userDetailsService)
                                .passwordEncoder(passwordEncoder());
        }

}
