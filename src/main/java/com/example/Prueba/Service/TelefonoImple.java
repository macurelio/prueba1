package com.example.Prueba.Service;

import com.example.Prueba.Model.Telefono;
import com.example.Prueba.Model.Usuario;
import com.example.Prueba.Repo.TelefonoRepository;
import com.example.Prueba.Repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefonoImple {

    @Autowired
    private TelefonoRepository telefonoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    public Telefono agregarDatos(Telefono telefono){


        telefono.setNumber(telefono.getNumber());
        telefono.setCitycode(telefono.getCitycode());
        telefono.setCountrycode(telefono.getCountrycode());
        //telefono.setUsuario(usuario1);

        return telefonoRepository.save(telefono);

    }







}
