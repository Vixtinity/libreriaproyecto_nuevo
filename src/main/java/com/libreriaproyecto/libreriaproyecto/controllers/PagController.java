package com.libreriaproyecto.libreriaproyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PagController {

    // Mapea la página de inicio
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Mapea la página "About"
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    // Mapea la página de productos
    @GetMapping("/products")
    public String productos() {
        return "products";
    }

    // Mapea la página "Store"
    @GetMapping("/store")
    public String store() {
        return "store";
}
@GetMapping("/login")
    public String login(Model model) {
        // No llames al método login nuevamente aquí, ya que causará recursión infinita
        return "login";  // Asegúrate de que el nombre de la vista sea correcto
    }
    
    
}
