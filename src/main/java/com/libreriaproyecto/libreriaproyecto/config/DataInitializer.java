package com.libreriaproyecto.libreriaproyecto.config;


import com.libreriaproyecto.libreriaproyecto.model.Entities.Autor;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Categoria;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Libro;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Usuario;
import com.libreriaproyecto.libreriaproyecto.model.Services.AutorService;
import com.libreriaproyecto.libreriaproyecto.model.Services.CategoriaService;
import com.libreriaproyecto.libreriaproyecto.model.Services.LibroService;
import com.libreriaproyecto.libreriaproyecto.model.Services.UsuarioService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AutorService autorService;
    private final CategoriaService categoriaService;
    private final LibroService libroService;
    private final UsuarioService usuarioService;

    public DataInitializer(AutorService autorService, CategoriaService categoriaService, LibroService libroService, UsuarioService usuarioService) {
        this.autorService = autorService;
        this.categoriaService = categoriaService;
        this.libroService = libroService;
        this.usuarioService = usuarioService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (autorService.count() == 0) {
            loadData();
        }
    }

    private void loadData() {
        System.out.println("Insertando datos iniciales...");

        List<Autor> autores = Arrays.asList(
            new Autor("Gabriel García Márquez", "Colombiana", "1927-03-06"),
            new Autor("J.K. Rowling", "Británica", "1965-07-31"),
            new Autor("George Orwell", "Británica", "1903-06-25"),
            new Autor("Isabel Allende", "Chilena", "1942-08-02"),
            new Autor("Stephen King", "Estadounidense", "1947-09-21")
        );
        autorService.saveAll(autores);

        // Insertar categorías
        List<Categoria> categorias = Arrays.asList(
            new Categoria("Novela"),
            new Categoria("Ciencia Ficción"),
            new Categoria("Terror"),
            new Categoria("Fantasía"),
            new Categoria("Historia")
        );
        categoriaService.saveAll(categorias);

        // Insertar libros
        List<Libro> libros = Arrays.asList(
            new Libro("Cien años de soledad", autores.get(0), categorias.get(0), 9.99),
            new Libro("Harry Potter y la piedra filosofal", autores.get(1), categorias.get(3), 8.50),
            new Libro("1984", autores.get(2), categorias.get(1), 5.99),
            new Libro("La casa de los fantasmas", autores.get(3), categorias.get(0), 15.39),
            new Libro("El resplandor", autores.get(4), categorias.get(2), 10.99)
        );
        libroService.saveAll(libros);

        // Insertar usuarios
        List<Usuario> usuarios = Arrays.asList(
            new Usuario("admin", "admin@example.com", "admin", "Calle A 123", "123456789","admin"),
            new Usuario("usuario", "usuario@example.com", "usuario", "Calle B 456", "987654321","usuario"),
            new Usuario("Carlos García", "carlos@example.com", "qwerty", "Calle C 789", "456123789","usuario")
        );
        usuarioService.saveAll(usuarios);

        System.out.println("Datos iniciales insertados.");
    }
}
