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
import org.springframework.web.bind.annotation.RequestParam;

import com.libreriaproyecto.libreriaproyecto.model.Entities.Autor;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Categoria;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Libro;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.*;
import com.libreriaproyecto.libreriaproyecto.model.Services.AutorService;
import com.libreriaproyecto.libreriaproyecto.model.Services.CategoriaService;
import com.libreriaproyecto.libreriaproyecto.model.Services.LibroService;

@Controller
@RequestMapping("/libro")
public class LibrosController {

    @Autowired
    private AutorService autorService; // Asegúrate de tener este servicio
    @Autowired
    private CategoriaService categoriaService; // Asegúrate de tener este servicio
    @Autowired
    private LibroService libroService;
    @Autowired
    private LibroRepository libroRepository;
    
    // Método para eliminar un libro
    @GetMapping("eliminar/{id}")
    public String eliminarLibro(@PathVariable Integer id) {
        libroService.eliminarLibro(id);
        return "redirect:/admin";
    }
    
    // Método para actualizar un libro
    @PostMapping("/actualizar")
    public String actualizarLibro(@ModelAttribute Libro libro) {
        libroService.actualizar(libro);
        return "redirect:/admin";
    }

    // Método para crear un libro
    @PostMapping("/crear")
    public String crearLibro(@ModelAttribute Libro libro, @RequestParam int autorId, @RequestParam int categoriaId) {
        // Obtener las entidades completas de Autor y Categoria usando sus ID
        Autor autor = autorService.findById(autorId);
        Categoria categoria = categoriaService.findById(categoriaId);

        // Asignar las entidades a las propiedades del libro
        libro.setAutor(autor);
        libro.setCategoria(categoria);

        // Guardar el libro
        libroService.guardar(libro);

        return "redirect:/admin"; // Redirigir al administrador o donde desees
    }

    // Mostrar la lista de libros
    @GetMapping("/libros")
    public String mostrarLibros(Model model) {
        List<Libro> libros = libroRepository.findAll(); // Obtener todos los libros desde la base de datos
        model.addAttribute("libros", libros); // Pasar la lista de libros al modelo
        return (model.containsAttribute("admin")) ? "admin/index" : "products"; // Redirigir a la vista correspondiente
    }
}
