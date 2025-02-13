package net.javaguides.registration_login_system.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // handler method to handle home page request
    @GetMapping("/index")
    public String home() {
        return "index";
    }

    // handler method to handle user registration form request

    @GetMapping
    public String showRegistrationForm() {
        return null;

    }
}
