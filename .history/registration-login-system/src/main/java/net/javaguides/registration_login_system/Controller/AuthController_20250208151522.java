package net.javaguides.registration_login_system.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.registration_login_system.dto.Userdto;

@Controller
public class AuthController {

    // handler method to handle home page request
    @GetMapping("/index")
    public String home() {
        return "index";
    }

    // handler method to handle user registration form request

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // create model object to store form data
        Userdto user = new Userdto();
        model.addAttribute("user", user);
        return "register";
    }
}
