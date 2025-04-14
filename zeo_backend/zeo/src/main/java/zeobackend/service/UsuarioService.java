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

    public boolean autenticar(String email, String contrasena) {
        logger.info("Intentando autenticar usuario: {} {}, modo persistente: {}", email, contrasena);
        
        boolean resultado;
        
        logger.debug("Buscando en base de datos H2");
        resultado = usuarioRepository.existsByEmailAndContrasena(email, contrasena);
        if (resultado) {
            return resultado;
        } 
        logger.debug("Buscando en memoria");
        resultado = usuarios.stream()
                    .anyMatch(u -> u.getEmail().equals(email) && u.getContrasena().equals(contrasena));
        
        logger.info("Resultado autenticación: {}", resultado);
        return resultado;
    }

    public List<Usuario> obtenerTodos() {
        logger.info("Obteniendo todos los usuarios, combinando BD y memoria");
    
        List<Usuario> resultado = new ArrayList<>();
    
        // Obtener de la base de datos
        List<Usuario> persistentes = usuarioRepository.findAll();
        logger.debug("Usuarios encontrados en BD: {}", persistentes.size());
        resultado.addAll(persistentes);
    
        // Agregar los usuarios en memoria
        logger.debug("Usuarios encontrados en memoria: {}", usuarios.size());
        resultado.addAll(usuarios);
    
        return resultado;
    }
    
    }
