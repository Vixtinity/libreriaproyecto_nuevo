package com.libreriaproyecto.libreriaproyecto.model.Entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.*;

@Entity
@Getter
@Setter
@Table (name = "libros")
@NoArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titulo")
    private String titulo;

    
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Libro(String titulo, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor.getNombre() +
                ", categoria=" + categoria.getNombre() +
                '}';
    }
}