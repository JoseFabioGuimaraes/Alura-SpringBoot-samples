package med.voll.api.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.Paciente.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private final PacienteRepository repository;

    public PacienteController(PacienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity criarPaciente(@RequestBody @Valid PacienteDTO dados, UriComponentsBuilder uriBuilder) {
        var paciente = new Paciente(dados);
        repository.save(paciente);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new PacienteDetalhadoDTO(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDTOListagem>> listaPaciente(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(PacienteDTOListagem::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listaPacienteDetalhado(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new PacienteDetalhadoDTO(paciente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePaciente(@RequestBody PacienteUpdateDTO dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.updateInfo(dados);
        return ResponseEntity.ok(new PacienteDetalhadoDTO(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> apagarPaciente(@PathVariable Long id) {
        var paciente = repository.findById(id);
        if (paciente.isPresent()) {
            paciente.get().excluir();
            return ResponseEntity.noContent().build();
        }
        throw new EntityNotFoundException("Paciente: "+id+" não encontrado");
    }
}
