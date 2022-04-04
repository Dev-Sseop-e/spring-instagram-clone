package com.cos.photogram.web;

import com.cos.photogram.domain.user.User;
import com.cos.photogram.service.AuthService;
import com.cos.photogram.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signup(SignupDto signupDto) {
        User user = signupDto.toEntity();
        User userEntity = authService.signupService(user);
        System.out.println(userEntity);
        return "auth/signin";
    }

}
