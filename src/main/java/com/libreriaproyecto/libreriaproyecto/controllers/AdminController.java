package com.libreriaproyecto.libreriaproyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.libreriaproyecto.libreriaproyecto.model.Entities.*;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.*;
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
    public String mostrarLibros(Model model) {
        List<Libro> libros = libroRepository.findAll();
        model.addAttribute("libros", libros);

        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);

        List<Autor> autores = autorRepository.findAll();
        model.addAttribute("autores", autores);

        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);

        return "admin/index";
    }
}

