package com.libreriaproyecto.libreriaproyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libreriaproyecto.libreriaproyecto.model.Entities.Usuario;
import com.libreriaproyecto.libreriaproyecto.model.Services.UsuarioService;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService; // Suponiendo que tienes un servicio para gestionar usuarios

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Nombre del archivo HTML del formulario de login
    }

    @PostMapping("/login")
    public String login(@RequestParam String nombre, @RequestParam String password) {
        Usuario usuario = usuarioService.findByNombre(nombre);

        if (usuario != null && password.equals(usuario.getPassword())) {
            if ("admin".equals(usuario.getRol())) {
                return "redirect:/admin";
            }
        }
        return "login";
    }
}
