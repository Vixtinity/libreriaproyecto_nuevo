package com.libreriaproyecto.libreriaproyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Libro;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.*;

@Controller
public class LibrosController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/libros")
    public String mostrarLibros(Model model) {
        List<Libro> libros = libroRepository.findAll(); // Esto obtiene todos los libros desde la base de datos
        model.addAttribute("libros", libros);  // Pasar la lista de libros al modelo
        return (model.containsAttribute("admin")) ? "admin/index" : "products";
    }
}

