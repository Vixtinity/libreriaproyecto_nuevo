package com.libreriaproyecto.libreriaproyecto.model.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.UsuarioRepository;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Usuario;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRep;

    public List<Usuario> getAll() {
        return this.usuarioRep.findAll();
    }

    public void create(Usuario usuario){
        this.usuarioRep.save(usuario);
    }

    public void delete(Integer id){
        this.usuarioRep.deleteById(id);
    }

    public Usuario getId(Integer id){
        return this.usuarioRep.findById(id).orElse(null);
    }
}
