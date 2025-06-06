package med.voll.api.Paciente;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private final PacienteRepository repository;
    public PacienteController(PacienteRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity criarUsuario(@RequestBody @Valid PacienteDTO dados, UriComponentsBuilder uriBuilder){
        var paciente = new Paciente(dados);
        repository.save(paciente);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new PacienteDetalhadoDTO(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDTOListagem>> listaPaciente(@PageableDefault(size=10,sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(PacienteDTOListagem::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity listaPacienteDetalhado(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new PacienteDetalhadoDTO(paciente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePaciente(@RequestBody PacienteUpdateDTO dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.updateInfo(dados);
        return ResponseEntity.ok(new PacienteDetalhadoDTO(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity apagarPaciente(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
        return ResponseEntity.noContent().build();
    }
}
