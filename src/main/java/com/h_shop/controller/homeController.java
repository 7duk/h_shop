package com.h_shop.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("hightech/")
public class homeController {
    @GetMapping("/home")
    public String ind(@NonNull HttpServletRequest request){
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @GetMapping("computers")
    public String computers(@NonNull HttpServletRequest request){
        return "computers";
    }
    @GetMapping("tablets")
    public String tablets(@NonNull HttpServletRequest request){
        return "tablets";
    }
    @GetMapping("cameras")
    public String cameras(@NonNull HttpServletRequest request){
        return "cameras";
    }
    @GetMapping("audios")
    public String audios(@NonNull HttpServletRequest request){
        return "audios";
    }
    @GetMapping("mobiles")
    public String mobiles(@NonNull HttpServletRequest request){
        return "mobiles";
    }
    @GetMapping("tivis")
    public String tivis(@NonNull HttpServletRequest request){
        return "Tivi";
    }
    @GetMapping("wearable-techs")
    public String wearable_techs(@NonNull HttpServletRequest request){
        return "WearableTech";
    }

}
