package com.educom.hiloservice.controllers;

import com.educom.hiloservice.models.Hilo;
import com.educom.hiloservice.services.HiloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hilos")
public class HiloController {
    @Autowired
    private HiloService hiloService;

    @GetMapping
    public List<Hilo> getAllHilos() {
        return hiloService.getAllHilos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hilo> getHiloById(@PathVariable Long id) {
        Hilo hilo = hiloService.getHiloById(id);
        return hilo != null ? ResponseEntity.ok(hilo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Hilo createHilo(@RequestBody Hilo hilo) {
        return hiloService.createHilo(hilo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hilo> updateHilo(@PathVariable Long id, @RequestBody Hilo hiloDetails) {
        Hilo hilo = hiloService.getHiloById(id);
        if (hilo == null) {
            return ResponseEntity.notFound().build();
        }
        hilo.setTitulo(hiloDetails.getTitulo());
        hilo.setMensaje(hiloDetails.getMensaje());
        hilo.setFechaCreacion(hiloDetails.getFechaCreacion());
        hilo.setLink(hiloDetails.getLink());
        hilo.setTopico(hiloDetails.getTopico());
        hilo.setUsuario(hiloDetails.getUsuario());
        Hilo updatedHilo = hiloService.updateHilo(hilo);
        return ResponseEntity.ok(updatedHilo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHilo(@PathVariable Long id) {
        hiloService.deleteHilo(id);
        return ResponseEntity.noContent().build();
    }
}
