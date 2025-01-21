package com.logic.tamil.security.jwt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logic.tamil.security.jwt.Security.Jwtutil;

// import lombok.Value;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private Jwtutil jwtUtil;

    @Value("${role.admin}")
    private String roleAdmin;

    @Value("${role.user}")
    private String roleUser;
}
