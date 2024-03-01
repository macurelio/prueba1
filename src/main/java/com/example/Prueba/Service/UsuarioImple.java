package com.example.Prueba.Service;

import com.example.Prueba.Model.Usuario;
import com.example.Prueba.Repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UsuarioImple implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TelefonoImple telefonoRepository;



        public Usuario newUser(Usuario usuario) {
            usuario.setCreated(new Date());
            usuario.setModified(new Date());
            usuario.setLastLogin(new Date());
            usuario.setToken(UUID.randomUUID().toString());
            usuario.setActive(true);

            usuario.setCitycode(usuario.getCitycode());
            usuario.setCountrycode(usuario.getCountrycode());

            return usuarioRepository.save(usuario);
        }
    public Usuario findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }
}
