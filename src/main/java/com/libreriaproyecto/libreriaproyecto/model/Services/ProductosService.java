package com.libreriaproyecto.libreriaproyecto.model.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreriaproyecto.libreriaproyecto.model.Entities.Productos;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.ProductosRepository;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productRepository;

    public List<Productos> getAllProducts() {
        return productRepository.findAll(); // Obtener todos los productos desde la base de datos
    }
}
