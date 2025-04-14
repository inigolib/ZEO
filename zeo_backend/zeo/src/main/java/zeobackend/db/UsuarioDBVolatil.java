package zeobackend.db;

import zeobackend.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDBVolatil extends UsuarioDB {

    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void registrar(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public boolean autenticar(String email, String contrasena) {
        return usuarios.stream().anyMatch(u ->
            u.getEmail().equals(email) && u.getContrasena().equals(contrasena)
        );
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarios;
    }
}

