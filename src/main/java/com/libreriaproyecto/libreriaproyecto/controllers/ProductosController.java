package com.libreriaproyecto.libreriaproyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.libreriaproyecto.libreriaproyecto.model.Entities.Libro;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.LibroRepository;

@Controller
public class ProductosController {

    @Autowired
    private LibroRepository libroRepository;

    // Mapea la página de productos
    @GetMapping("/products")  // Cambié la ruta a "/products" para que no se solape con la raíz "/"
    public String mostrarLibros(Model model) {
        List<Libro> libros = libroRepository.findAll();  // Obtener todos los libros de la base de datos
        model.addAttribute("libros", libros);  // Pasar la lista de libros al modelo
        return "products";  // Vista de los productos
    }
}
