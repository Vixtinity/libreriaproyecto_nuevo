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

import com.libreriaproyecto.libreriaproyecto.model.Services.CategoriaService;
import com.libreriaproyecto.libreriaproyecto.model.Services.LibroService;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Categoria;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Libro;

@Controller
@RequestMapping("/categoria")
public class CategoriasController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Integer id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/admin";
    }

    @PostMapping("/actualizar")
    public String actualizarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.actualizar(categoria);
        return "redirect:/admin";
    }
@PostMapping("/crear")
public String crearUsuario(@ModelAttribute Categoria categoria) {
    categoriaService.guardar(categoria);
    return "redirect:/admin";
}


    @GetMapping("/categorias")
    public String getCategorias(Model modelo) {
        List<Categoria> categorias = this.categoriaService.findAll();
        modelo.addAttribute("categorias", categorias);
        return "index";
    }
}

