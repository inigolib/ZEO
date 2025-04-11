package zeobackend.model;
import lombok.Data;

@Data
public class Usuario {
    private String nombre;
    private int edad;
    private String email;
    private String contrasena;
}