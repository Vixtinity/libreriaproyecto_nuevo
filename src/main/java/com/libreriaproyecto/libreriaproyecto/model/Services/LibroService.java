package com.libreriaproyecto.libreriaproyecto.model.Services;

import org.springframework.stereotype.Service;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.LibroRepository;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Libro;

import java.util.List;

@Service
public class LibroService {
    
    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public void eliminarLibro(Integer id) {
        repository.deleteById(id);
    }
    public void actualizar(Libro libro) {
        repository.save(libro);
    }

    public List<Libro> findAll() {
        return repository.findAll();
    }

    public Libro save(Libro libro) {
        return repository.save(libro);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
    public void guardar(Libro libro) {
        repository.save(libro);
    }

    public Libro findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void saveAll(List<Libro> libros) {
        repository.saveAll(libros);
    }
}
