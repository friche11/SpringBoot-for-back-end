package com.example.friche.SpringWeb.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.friche.SpringWeb.services.CookieService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    //Rota para home page
    @GetMapping("/")
    public String index(Model model, HttpServletRequest request)  throws UnsupportedEncodingException{
        String nomeUsuario = CookieService.getCookie(request, "usuarioNome");
        if (nomeUsuario != null) {
        model.addAttribute("nome", URLDecoder.decode(nomeUsuario, "UTF-8"));
}
        return "home/index";
    }

}
