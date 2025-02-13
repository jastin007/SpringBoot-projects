package net.javaguides.registration_login_system.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import net.javaguides.registration_login_system.Entity.User;
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
    public String registration(@Valid @ModelAttribute("user") Userdto userDto,
            BindingResult result, Model model) {
        User existingUser = userservice.findUserByEmail(userDto.getEmail());

        if (existingUser != null) {
            result.rejectValue("email", null, "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", existingUser);
            return "/register";
        }
        userservice.saveUser(userDto);
        return "redirect:/register?success";
    }

}
