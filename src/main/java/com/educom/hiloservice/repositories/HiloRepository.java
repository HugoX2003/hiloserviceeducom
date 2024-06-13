package com.educom.hiloservice.repositories;

import com.educom.hiloservice.models.Hilo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HiloRepository extends JpaRepository<Hilo, Long> {
}
