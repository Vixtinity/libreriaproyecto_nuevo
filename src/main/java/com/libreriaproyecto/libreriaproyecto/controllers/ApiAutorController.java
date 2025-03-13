package com.libreriaproyecto.libreriaproyecto.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.libreriaproyecto.libreriaproyecto.model.Services.*;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Autor;
@RestController
@RequestMapping("/api/autores")
public class ApiAutorController {
    @Autowired
    private AutorService AutorService;
    @GetMapping("/")
    public List<Autor> getAll() {
        return AutorService.findAll();
    }
}
