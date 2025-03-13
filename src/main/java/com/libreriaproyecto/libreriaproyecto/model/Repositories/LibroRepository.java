package com.libreriaproyecto.libreriaproyecto.model.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libreriaproyecto.libreriaproyecto.model.Entities.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {}