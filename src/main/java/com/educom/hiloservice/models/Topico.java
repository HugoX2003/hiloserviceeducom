package com.educom.hiloservice.models;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Date fechaCreacion;

    @ManyToMany
    @JoinTable(
            name = "topico_categoria",
            joinColumns = @JoinColumn(name = "topico_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Hilo> hilos;
}
