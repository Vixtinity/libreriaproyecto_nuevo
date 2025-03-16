package com.libreriaproyecto.libreriaproyecto.model.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.UsuarioRepository;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Categoria;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Usuario;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void create(Usuario usuario) {
        this.usuarioRepository.save(usuario);  // Utilizar el repositorio inyectado
    }
        public void actualizar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }


    public void delete(Integer id) {
        this.usuarioRepository.deleteById(id);  // Utilizar el repositorio inyectado
    }

    public Usuario getId(Integer id) {
        return this.usuarioRepository.findById(id).orElse(null);  // Utilizar el repositorio inyectado
    }

    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);  // Utilizar el repositorio inyectado
    }

    public void saveAll(List<Usuario> usuarios) {
        usuarioRepository.saveAll(usuarios);  // Utilizar el repositorio inyectado
    }

    // Método para buscar usuario por nombre
    public Usuario findByNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);  // Llama al repositorio para buscar el usuario
    }
}
