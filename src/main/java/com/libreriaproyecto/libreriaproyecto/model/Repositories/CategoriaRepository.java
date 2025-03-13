package com.libreriaproyecto.libreriaproyecto.model.Repositories;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {}
