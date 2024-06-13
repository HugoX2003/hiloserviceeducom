package com.educom.hiloservice.models;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @ManyToMany(mappedBy = "categorias")
    private Set<Topico> topicos;
}
