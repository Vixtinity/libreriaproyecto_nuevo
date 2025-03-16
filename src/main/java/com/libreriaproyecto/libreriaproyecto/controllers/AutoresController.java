package com.libreriaproyecto.libreriaproyecto.controllers;
    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libreriaproyecto.libreriaproyecto.model.Services.AutorService;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Autor;


@Controller
@RequestMapping("/autor")
public class AutoresController {
    @Autowired
    private AutorService autorService;
        @GetMapping("/eliminar/{id}")
    public String eliminarAutor(@PathVariable Integer id) {
        autorService.eliminarAutor(id);
        return "redirect:/admin";
    }

   @PostMapping("/actualizar")
    public String actualizarCategoria(@ModelAttribute Autor autor) {
        autorService.actualizar(autor);
        return "redirect:/admin";
    }
}
