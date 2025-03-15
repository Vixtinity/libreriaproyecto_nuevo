package com.libreriaproyecto.libreriaproyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.libreriaproyecto.libreriaproyecto.model.Entities.Libro;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Categoria;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Autor;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Usuario;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.LibroRepository;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.CategoriaRepository;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.AutorRepository;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.UsuarioRepository;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        List<Libro> libros = libroRepository.findAll();
        List<Categoria> categorias = categoriaRepository.findAll();
        List<Autor> autores = autorRepository.findAll();
        List<Usuario> usuarios = usuarioRepository.findAll();

        // Agregar los datos al modelo para que puedan ser utilizados en la vista
        model.addAttribute("libros", libros);
        model.addAttribute("categorias", categorias);
        model.addAttribute("autores", autores);
        model.addAttribute("usuarios", usuarios);

        return "admin/index";  // Vista de administración
    }
}
