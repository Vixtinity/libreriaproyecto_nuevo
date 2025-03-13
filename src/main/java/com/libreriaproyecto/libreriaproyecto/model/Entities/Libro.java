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
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "stock")
    private Integer stock;
    
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Libro(String titulo, Autor autor, Categoria categoria, double precio, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }
}