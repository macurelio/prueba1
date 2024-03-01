package Service;

import Model.Telefono;
import Model.Usuario;
import Repo.TelefonoRepository;
import Repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImple implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TelefonoRepository telefonoRepository;

    @Override
    public Usuario newUser(Usuario usuario) {
        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        for (Telefono telefono : usuario.getPhones()) {
            telefono.setUsuario(usuario);
            telefonoRepository.save(telefono);
        }

        return usuarioRepository.save(usuario);
    }
}
