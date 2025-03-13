package com.libreriaproyecto.libreriaproyecto.model.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.AutorRepository;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Autor;

@Service
public class AutorService {
    @Autowired
    private AutorRepository repository;

    public List<Autor> findAll() {
        return repository.findAll();
    }

    public Autor save(Autor autor) {
        return repository.save(autor);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Autor findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
    public void saveAll(List<Autor> autores) {
        repository.saveAll(autores);
    }
    public long count() {
        return repository.count();
    }
}