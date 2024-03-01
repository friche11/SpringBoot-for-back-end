package com.example.friche.SpringWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradoresController {

    //Rota para home page
    @GetMapping("/administradores")
    public String index(){
        return "administradores/index";
    }

}
