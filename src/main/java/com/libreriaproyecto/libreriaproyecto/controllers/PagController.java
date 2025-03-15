package com.libreriaproyecto.libreriaproyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PagController {

    // Mapea la página de inicio
    @GetMapping("/")
    public String index() {
        return "index"; // Vista de la página principal
    }

    // Mapea la página "About"
    @GetMapping("/about")
    public String about() {
        return "about"; // Vista de la página "About"
    }

    // Mapea la página "Store"
    @GetMapping("/store")
    public String store() {
        return "store"; // Vista de la tienda
    }

    // Mapea la página de login
    @GetMapping("/login")
    public String login(Model model) {
        return "login"; // Vista de login
    }
}

