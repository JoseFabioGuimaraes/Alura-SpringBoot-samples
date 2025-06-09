package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.domain.usuario.UsuarioAutenticacaoDTO;
import med.voll.api.infra.security.TokenJWTDTO;
import med.voll.api.infra.security.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;


    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService){
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid UsuarioAutenticacaoDTO json){
        var AutenticationToken = new UsernamePasswordAuthenticationToken(json.login(), json.senha());
        var authentication = manager.authenticate(AutenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJWTDTO(tokenJWT));
    }

}
