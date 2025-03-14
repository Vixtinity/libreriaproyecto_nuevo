package com.libreriaproyecto.libreriaproyecto.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.libreriaproyecto.libreriaproyecto.model.Services.AutorService;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Autor;

@Controller
public class AutoresController {
    @Autowired
    private AutorService autorService;

    @GetMapping("/autores")
    public String getAutores(Model modelo) {
        List<Autor> autores = this.autorService.findAll();
        modelo.addAttribute("autores", autores);
        return "/www/autores/listar";
    }

    @GetMapping("/autores/{id}")
    public String getAutor(@PathVariable(value="id", required=false) Integer id, Model vista) {
        System.out.println("El autor es " + id);
        Autor autor = this.autorService.findById(id);
        System.out.println(autor);

        vista.addAttribute("autor", autor);
        return "/www/autores/detalle";
    }
}
