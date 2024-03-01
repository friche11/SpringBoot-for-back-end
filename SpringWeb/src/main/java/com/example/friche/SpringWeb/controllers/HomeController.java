package com.example.friche.SpringWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //Rota para home page
    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("nome", "Victor");
        return "home/index";
    }

}
