package com.cos.photogram.web;

import com.cos.photogram.domain.user.User;
import com.cos.photogram.handler.ex.CustomValidationException;
import com.cos.photogram.service.AuthService;
import com.cos.photogram.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) { // pre-processing
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustomValidationException("Validation check failed", errorMap);
        } else {
            User user = signupDto.toEntity();
            authService.signupService(user);
            // System.out.println(userEntity);

            // Remain log (post-processing)
            return "auth/signin";
        }

    }

}
