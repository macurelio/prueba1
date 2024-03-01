package Controler;

import Model.Usuario;
import Service.UsuarioImple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class UsuarioController {

    @Autowired
    private UsuarioImple usuarioService;

    @GetMapping("/")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@Validated Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registro";
        }
        usuarioService.newUser(usuario);
        return "redirect:/registro?success";
    }
}
