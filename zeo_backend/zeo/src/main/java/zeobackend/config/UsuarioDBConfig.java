package zeobackend.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zeobackend.db.UsuarioDB;
import zeobackend.db.UsuarioDBVolatil;
import zeobackend.db.UsuarioDBPermanente;
import zeobackend.repository.UsuarioRepository;

@Configuration
public class UsuarioDBConfig {

    @Bean
    @ConditionalOnProperty(name = "usuario-persistente.enabled", havingValue = "true")
    public UsuarioDB usuarioPermanenteDB(UsuarioRepository usuarioRepository) {
        return new UsuarioDBPermanente(usuarioRepository);
    }
    
    @Bean
    @ConditionalOnProperty(name = "usuario-persistente.enabled", havingValue = "false", matchIfMissing = true)
    public UsuarioDB usuarioVolatilDB() {
        return new UsuarioDBVolatil();
    }
}
