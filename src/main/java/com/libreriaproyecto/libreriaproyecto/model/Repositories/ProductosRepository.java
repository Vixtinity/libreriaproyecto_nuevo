package com.libreriaproyecto.libreriaproyecto.model.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
    // Métodos personalizados si es necesario
}