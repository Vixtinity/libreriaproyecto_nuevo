package com.libreriaproyecto.libreriaproyecto.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.libreriaproyecto.libreriaproyecto.model.Services.LibroService;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Libro;

@Controller
public class LibrosController {
    @Autowired
    private LibroService libroService;

    @GetMapping("/libros")
    public String getLibros(Model modelo) {
        List<Libro> libros = this.libroService.findAll();
        modelo.addAttribute("libros", libros);
        return "/www/libros/listar";
    }

    @GetMapping("/libros/{id}")
    public String getLibro(@PathVariable(value="id", required=false) Integer id, Model vista) {
        System.out.println("El libro es " + id);
        Libro libro = this.libroService.findById(id);
        System.out.println(libro);

        vista.addAttribute("libro", libro);
        return "/www/libros/detalle";
    }
}
