package zeobackend.service;

import zeobackend.model.Usuario;
import zeobackend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsuarioService {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);
    private final List<Usuario> usuarios = new ArrayList<>();
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void registrar(Usuario usuario, boolean persistente) {
        logger.info("Registrando usuario con email: {}, modo persistente: {}", usuario.getEmail(), persistente);
        
        if (persistente) {
            logger.debug("Guardando en base de datos H2");
            Usuario guardado = usuarioRepository.save(usuario);
            logger.debug("Usuario guardado en BD con ID: {}", guardado.getId());
        } else {
            logger.debug("Guardando en memoria");
            usuarios.add(usuario);
        }
    }

    public boolean autenticar(String email, String contrasena, boolean persistente) {
        logger.info("Intentando autenticar usuario: {}, modo persistente: {}", email, persistente);
        
        boolean resultado;
        if (persistente) {
            logger.debug("Buscando en base de datos H2");
            resultado = usuarioRepository.existsByEmailAndContrasena(email, contrasena);
        } else {
            logger.debug("Buscando en memoria");
            resultado = usuarios.stream()
                    .anyMatch(u -> u.getEmail().equals(email) && u.getContrasena().equals(contrasena));
        }
        
        logger.info("Resultado autenticación: {}", resultado);
        return resultado;
    }

    public List<Usuario> obtenerTodos(boolean persistente) {
        logger.info("Obteniendo todos los usuarios, modo persistente: {}", persistente);
        
        List<Usuario> resultado;
        if (persistente) {
            logger.debug("Obteniendo de base de datos H2");
            resultado = usuarioRepository.findAll();
            logger.debug("Usuarios encontrados en BD: {}", resultado.size());
        } else {
            logger.debug("Obteniendo de memoria");
            resultado = usuarios;
        }
        
        return resultado;
    }
}