package zeobackend.controller;

import zeobackend.model.Usuario;
import zeobackend.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/alta")
    public String alta(@RequestBody Usuario usuario) {
    usuarioService.registrar(usuario);
    return "Usuario registrado";
}

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        boolean ok = usuarioService.autenticar(
            usuario.getEmail(),
            usuario.getContrasena());
        return ok ? "Login correcto" : "Login incorrecto";
    }
    

    @GetMapping("/listado")
    public List<Usuario> listado() {
        return usuarioService.obtenerTodos();
    }
}