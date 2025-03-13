package com.libreriaproyecto.libreriaproyecto.model.Entities;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Table (name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
}
