package com.educom.hiloservice.services;

import com.educom.hiloservice.models.Hilo;
import com.educom.hiloservice.repositories.HiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HiloService {
    @Autowired
    private HiloRepository hiloRepository;

    public List<Hilo> getAllHilos() {
        return hiloRepository.findAll();
    }

    public Hilo getHiloById(Long id) {
        return hiloRepository.findById(id).orElse(null);
    }

    public Hilo createHilo(Hilo hilo) {
        return hiloRepository.save(hilo);
    }

    public void deleteHilo(Long id) {
        hiloRepository.deleteById(id);
    }

    public Hilo updateHilo(Hilo hilo) {
        return hiloRepository.save(hilo);
    }
}
