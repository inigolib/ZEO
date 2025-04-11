package zeobackend.service;

import zeobackend.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private final List<Usuario> usuarios = new ArrayList<>();

    public void registrar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean autenticar(String email, String contrasena) {
        return usuarios.stream()
                .anyMatch(u -> u.getEmail().equals(email) && u.getContrasena().equals(contrasena));
    }

    public List<Usuario> obtenerTodos() {
        return usuarios;
    }
}
