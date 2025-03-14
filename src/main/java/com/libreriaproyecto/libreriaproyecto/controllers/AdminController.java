package com.libreriaproyecto.libreriaproyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.libreriaproyecto.libreriaproyecto.model.Entities.Libro;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.LibroRepository;
import com.libreriaproyecto.libreriaproyecto.model.*;
@Controller
public class AdminController {
    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/index")
    public String mostrarLibros(Model model) {
        List<Libro> libros = libroRepository.findAll();
        model.addAttribute("libros", libros);
        return "admin/index";
    }
}

