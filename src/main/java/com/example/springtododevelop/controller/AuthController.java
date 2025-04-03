package com.example.springtododevelop.controller;

import com.example.springtododevelop.dto.auth.LoginRequestDto;
import com.example.springtododevelop.dto.auth.LoginResponseDto;
import com.example.springtododevelop.service.AuthService;
import com.example.springtododevelop.service.UserService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

//    @PostMapping("/signup")
//    public void signup() {
//
//    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
        @ModelAttribute LoginRequestDto requestDto,
        ServletRequest servletRequest
    ) {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginResponseDto loginUser = authService.login(email, password);

        if (loginUser != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", loginUser);
            session.setMaxInactiveInterval(60 * 30);
        }

        return new ResponseEntity<>(loginUser, HttpStatus.OK);

    }

}
