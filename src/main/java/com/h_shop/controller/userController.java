package com.h_shop.controller;

import com.h_shop.auth.AuthenticationRequest;
import com.h_shop.service.AuthenticationService;
import com.h_shop.auth.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class userController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public String register(@ModelAttribute(name = "request") RegisterRequest request) {
        System.out.println("register");
        request.setRole(1);
        service.register(request);
        System.out.println(request.toString());
        return "redirect:/hightech/login";

    }

    @PostMapping("/authenticate")
    public String authenticate(@ModelAttribute(name = "request") AuthenticationRequest request,@NonNull HttpServletRequest servletRequest) {
        System.out.println("111authenticate");
        System.out.println(request.getEmail() + "----" + request.getPassword());
        servletRequest.getSession().setAttribute("Authorization","Bearer "+service.authenticate(request).getToken());
        return "redirect:/hightech/home";
    }
}
