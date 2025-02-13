package net.javaguides.registration_login_system.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.registration_login_system.dto.Userdto;
import net.javaguides.registration_login_system.service.UserService;

@Controller
public class AuthController {

    private UserService userservice;

    public AuthController(UserService userservice) {
        this.userservice = userservice;
    }

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

    // handler method to handle user registration form submit request

    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") Userdto userDto) {
        userservice.saveUser(userDto);
        return "redirect:/register?success";
    }
}
