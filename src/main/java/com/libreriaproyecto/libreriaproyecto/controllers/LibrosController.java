package com.libreriaproyecto.libreriaproyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libreriaproyecto.libreriaproyecto.model.Entities.Libro;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.*;
import com.libreriaproyecto.libreriaproyecto.model.Services.LibroService;

@Controller
@RequestMapping("/libro")
public class LibrosController {

    @Autowired
    private LibroRepository libroRepository;
        @Autowired
    private LibroService libroService;
        @GetMapping("eliminar/{id}")
    public String eliminarLibro(@PathVariable Integer id) {
        libroService.eliminarLibro(id);
        return "redirect:/admin";
    }
    
    @PostMapping("/actualizar")
    public String actualizarLibro(@ModelAttribute Libro libro) {
        libroService.actualizar(libro);
        return "redirect:/admin";
    }
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroService.guardar(libro);
        return "redirect:/admin";  // Redirige a la página de administración después de guardar
    }
    
    @GetMapping("/libros")
    public String mostrarLibros(Model model) {
        List<Libro> libros = libroRepository.findAll(); // Esto obtiene todos los libros desde la base de datos
        model.addAttribute("libros", libros);  // Pasar la lista de libros al modelo
        return (model.containsAttribute("admin")) ? "admin/index" : "products";
    }
}

