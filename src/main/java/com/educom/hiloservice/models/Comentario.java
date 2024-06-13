package com.educom.hiloservice.models;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    private Date fechaCreacion;
    private String link;

    @ManyToOne
    @JoinColumn(name = "hilo_id")
    private Hilo hilo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
