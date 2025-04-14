Correr `ng serve` en zeo_frontend para correr el servidor del frontend. En localhost:4200 se podrá ver la pantalla de inicio de sesión.

Correr `mvn spring-boot:run` en `zeo_backend/zeo` para correr el servidor del backend.

Para modificar el funcionamiento volátil/permanente, se puede hacer en el campo 'usuario-persistente.enabled=false' ubicado en 'zeo/zeo_backend/zeo/src/main/resources/application.properties'.
False es volátil y true permanente. True guardará los valores en H2.
