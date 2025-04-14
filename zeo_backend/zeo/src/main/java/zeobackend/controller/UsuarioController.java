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
        System.out.println(usuario);
        System.out.println("ES O NO ES");
        System.out.println(usuario.getPersistente());

        usuarioService.registrar(usuario, usuario.getPersistente());
        return "Usuario registrado";
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario, @RequestParam(defaultValue = "false") boolean persistente) {
        boolean ok = usuarioService.autenticar(usuario.getEmail(), usuario.getContrasena(), persistente);
        return ok ? "Login correcto" : "Login incorrecto";
    }

    @GetMapping("/listado")
    public List<Usuario> listado(@RequestParam(defaultValue = "false") boolean persistente) {
        List<Usuario> usuarios = usuarioService.obtenerTodos(persistente);
        usuarios.forEach(System.out::println);
        return usuarios;
    }
}