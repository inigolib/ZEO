package zeobackend.db;

import zeobackend.model.Usuario;
import zeobackend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UsuarioDBPermanente extends UsuarioDB {

    private final UsuarioRepository usuarioRepository;

    @Override
    public void registrar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public boolean autenticar(String email, String contrasena) {
        return usuarioRepository.findAll().stream().anyMatch(u ->
            u.getEmail().equals(email) && u.getContrasena().equals(contrasena)
        );
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }
}
