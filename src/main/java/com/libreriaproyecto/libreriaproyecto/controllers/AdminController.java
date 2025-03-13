package com.libreriaproyecto.libreriaproyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminIndex() {
        return "admin/index";  // Sin la extensión .html
    }
}

