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
        return "www/admin/index";
    }

    @GetMapping("/categorias/{id}")
    public String getCategoria(@PathVariable(value="id", required=false) Integer id, Model vista) {
        System.out.println("La categoría es " + id);
        Categoria categoria = this.categoriaService.findById(id);
        System.out.println(categoria);

        vista.addAttribute("categoria", categoria);
        return "/www/admin/index";
    }
}
