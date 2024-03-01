package com.example.Prueba.Repo;

import com.example.Prueba.Model.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface TelefonoRepository extends JpaRepository<Telefono, Long> {
    }

