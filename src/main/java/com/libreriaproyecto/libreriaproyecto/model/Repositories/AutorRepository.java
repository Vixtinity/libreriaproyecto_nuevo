package com.libreriaproyecto.libreriaproyecto.model.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libreriaproyecto.libreriaproyecto.model.Entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {}
