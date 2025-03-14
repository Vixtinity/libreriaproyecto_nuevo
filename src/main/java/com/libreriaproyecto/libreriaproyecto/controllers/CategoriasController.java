package com.libreriaproyecto.libreriaproyecto.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.libreriaproyecto.libreriaproyecto.model.Services.CategoriaService;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Categoria;

@Controller
public class CategoriasController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public String getCategorias(Model modelo) {
        List<Categoria> categorias = this.categoriaService.findAll();
        modelo.addAttribute("categorias", categorias);
        return "index";
    }
}
