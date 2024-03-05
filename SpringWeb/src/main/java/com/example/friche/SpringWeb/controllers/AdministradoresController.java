package com.example.friche.SpringWeb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.friche.SpringWeb.models.Administrador;
import com.example.friche.SpringWeb.repositorio.AdministradoresRepo;


@Controller
public class AdministradoresController {

    @Autowired
    private AdministradoresRepo repo;

    //Rota para página de admin
    @GetMapping("/administradores")
    public String index(Model model){
        List<Administrador> administradores = (List<Administrador>) repo.findAll();
        model.addAttribute("administradores", administradores);
        return "administradores/index";
    }

    //Rota para página de cadastro de admin
    @GetMapping("/administradores/novo")
    public String novo(){
        return "administradores/novo";
    }

    //Rota para metodo POST de cadastro
    @PostMapping("/administradores/criar")
    public String criar(Administrador administrador){
        repo.save(administrador);
        return "redirect:/administradores";
    }

    //Rota para alterar cadastro
    @GetMapping("/administradores/{id}")
    public String buscar(@PathVariable int id, Model model){
        Optional<Administrador> admin = repo.findById(id);
        try{
        model.addAttribute("administrador", admin.get());
        }catch(Exception err){
            return "redirect:/administradores";
        }
        return "administradores/editar";
    }

    //Rota para alterar cadastro no banco
    @PostMapping("/administradores/{id}/atualizar")
    public String atualizar(@PathVariable int id, Administrador administrador){
       if(!repo.exist(id)){
        return "redirect:/administradores";
       }
       repo.save(administrador);
        return "redirect:/administradores";
    }

    //Rota para excluir cadastro
    @GetMapping("/administradores/{id}/excluir")
    public String excluir(@PathVariable int id){
        repo.deleteById(id);
        return "redirect:/administradores";
    }

}
