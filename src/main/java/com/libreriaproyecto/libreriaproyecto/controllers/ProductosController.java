package com.libreriaproyecto.libreriaproyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Productos;
import com.libreriaproyecto.libreriaproyecto.model.Services.ProductosService;

@Controller
public class ProductosController {

    @Autowired
    private ProductosService productService;

    @GetMapping("/productos")
    public String showProducts(Model model) {
        List<Productos> productos = productService.getAllProducts(); // Corregido: Usar productService en lugar de productServices
        model.addAttribute("productos", productos); // Añade los productos al modelo para pasarlos a la vista
        return "productos"; // Nombre de la vista (productos.html)
    }
}
