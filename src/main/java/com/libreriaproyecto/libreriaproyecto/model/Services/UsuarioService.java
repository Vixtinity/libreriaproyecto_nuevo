package com.libreriaproyecto.libreriaproyecto.model.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.UsuarioRepository;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Usuario;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getAll() {
        return this.repository.findAll();
    }

    public void create(Usuario usuario){
        this.repository.save(usuario);
    }

    public void delete(Integer id){
        this.repository.deleteById(id);
    }

    public Usuario getId(Integer id){
        return this.repository.findById(id).orElse(null);
    }
        public void saveAll(List<Usuario> usuarios) {
        repository.saveAll(usuarios);
    }
}
