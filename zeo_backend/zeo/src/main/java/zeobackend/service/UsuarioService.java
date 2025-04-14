package zeobackend.service;

import zeobackend.db.UsuarioDB;
import zeobackend.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDB usuarioDB;

    public void registrar(Usuario usuario) {
        usuarioDB.registrar(usuario);
    }

    public boolean autenticar(String email, String contrasena) {
        return usuarioDB.autenticar(email, contrasena);
    }

    public List<Usuario> obtenerTodos() {    
        return usuarioDB.obtenerTodos();
    }
    
    }
