package com.foro_alura.controller;


import com.foro_alura.domain.usuario.AutenticacionUsuarioDTO;
import com.foro_alura.domain.usuario.Usuario;
import com.foro_alura.infra.security.JWTtokenDTO;
import com.foro_alura.infra.security.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Autenticación", description = "Obtiene el token del usuario designado para el acceso.")
public class AutentificacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<JWTtokenDTO> autenticarUsuario(@RequestBody @Valid AutenticacionUsuarioDTO autenticacionUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(autenticacionUsuario.username(),
                autenticacionUsuario.password());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok(new JWTtokenDTO(JWTtoken));
    }
}
