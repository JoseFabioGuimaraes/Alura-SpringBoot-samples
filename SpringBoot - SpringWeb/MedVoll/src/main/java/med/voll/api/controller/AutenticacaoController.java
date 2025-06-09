package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuario.UsuarioAutenticacaoDTO;
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

    public AutenticacaoController(AuthenticationManager manager){
        this.manager = manager;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid UsuarioAutenticacaoDTO json){
        var token = new UsernamePasswordAuthenticationToken(json.login(), json.senha());
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok().build();
    }

}
