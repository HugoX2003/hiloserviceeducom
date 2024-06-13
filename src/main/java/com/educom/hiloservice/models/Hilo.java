package com.educom.hiloservice.models;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Hilo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private Date fechaCreacion;
    private String link;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @OneToMany(mappedBy = "hilo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comentario> comentarios;
}
