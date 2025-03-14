package com.libreriaproyecto.libreriaproyecto.model.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Aquí puedes añadir métodos personalizados si es necesario
}
