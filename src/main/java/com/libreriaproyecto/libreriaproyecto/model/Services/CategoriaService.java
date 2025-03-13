package com.libreriaproyecto.libreriaproyecto.model.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libreriaproyecto.libreriaproyecto.model.Repositories.CategoriaRepository;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Categoria;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Categoria findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
        public void saveAll(List<Categoria> categorias) {
        repository.saveAll(categorias);
    }
}
