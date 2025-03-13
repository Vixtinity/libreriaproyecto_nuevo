package com.libreriaproyecto.libreriaproyecto.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.libreriaproyecto.libreriaproyecto.model.Services.LibroService;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Libro;

@Controller
public class LibrosController {

    private final LibroService libroService;

    public LibrosController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/libros")
    public String getLibros(Model modelo) {
        List<Libro> libros = libroService.findAll();
        modelo.addAttribute("libros", libros);
        return "libros/listar"; // Corrección de la ruta de la vista
    }

    @GetMapping("/libros/{id}")
    public String getLibro(@PathVariable("id") Integer id, Model vista) {
        System.out.println("El libro es " + id);

        Libro libro = libroService.findById(id);
        if (libro == null) {
            System.out.println("Libro no encontrado");
            return "redirect:/libros"; // Redirige a la lista si el libro no existe
        }

        vista.addAttribute("libro", libro);
        return "libros/detalle"; // Corrección de la ruta de la vista
    }
}
