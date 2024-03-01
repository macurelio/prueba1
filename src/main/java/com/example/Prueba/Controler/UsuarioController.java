package com.example.Prueba.Controler;

import com.example.Prueba.Model.Telefono;
import com.example.Prueba.Model.Usuario;
import com.example.Prueba.Repo.TelefonoRepository;
import com.example.Prueba.Service.UsuarioImple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;


@Controller
@Slf4j
public class UsuarioController {

    @Autowired
    private UsuarioImple usuarioService;
    @Autowired
    private TelefonoRepository telefonoService;



    @GetMapping("/")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@Validated @ModelAttribute Usuario usuario, BindingResult result, Model model) {
        Usuario usuarioExistente = usuarioService.findByCorreo(usuario.getCorreo());
        if (usuarioExistente != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body("redirect:/error");
        }
        String token = UUID.randomUUID().toString();
        usuario.setToken(token);

        Usuario nuevoUsuario = usuarioService.newUser(usuario);
        Telefono telefono = new Telefono();
        telefono.setUsuario(nuevoUsuario);
        telefono.setCitycode(nuevoUsuario.getCitycode());
        telefono.setCountrycode(nuevoUsuario.getCountrycode());
        telefono.setNumber(nuevoUsuario.getTelefono());
        telefonoService.save(telefono);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente");
    }
}

