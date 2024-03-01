package com.example.Prueba.Repo;

import com.example.Prueba.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreo(String correo);



    Usuario getUsuarioById (Long id);
}

