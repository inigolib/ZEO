package zeobackend.db;

import zeobackend.model.Usuario;
import java.util.List;

public abstract class UsuarioDB {
    public abstract void registrar(Usuario usuario);
    public abstract boolean autenticar(String email, String contrasena);
    public abstract List<Usuario> obtenerTodos();
}

