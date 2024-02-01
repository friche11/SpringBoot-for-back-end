package com.example.friche.SpringWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //Rota para home page
    @GetMapping("/")
    public String index(){
        return "home/index";
    }

}
