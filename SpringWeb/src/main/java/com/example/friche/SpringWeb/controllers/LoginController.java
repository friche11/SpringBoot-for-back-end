package com.example.friche.SpringWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.friche.SpringWeb.models.Administrador;
import com.example.friche.SpringWeb.repositorio.AdministradoresRepo;
import com.example.friche.SpringWeb.services.CookieService;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class LoginController {

    @Autowired
    private AdministradoresRepo repo;

    //Rota para página de login
    @GetMapping("/login")
    public String index(){
        return "login/index";
    }

    //Rota para realizar login
    @PostMapping("/logar")
    public String logar(Model model, Administrador administrador, String lembrar, HttpServletResponse response){
        Administrador adm = this.repo.login(administrador.getEmail(), administrador.getSenha());
        int tempoLogado = (60*60); //1 dia logado
        if(lembrar != null) {
            tempoLogado = (60*60*24*365); //1 ano logado
        }
        if(adm != null){
            CookieService.setCookie(response, "usuarioId", String.valueOf(adm.getId()), tempoLogado);
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/index";
    }


}
