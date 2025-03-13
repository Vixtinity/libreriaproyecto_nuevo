package com.libreriaproyecto.libreriaproyecto.model.Repositories;

import com.libreriaproyecto.libreriaproyecto.model.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}