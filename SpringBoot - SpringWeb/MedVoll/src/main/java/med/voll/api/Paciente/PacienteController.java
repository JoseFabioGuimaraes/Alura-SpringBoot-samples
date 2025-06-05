package med.voll.api.Paciente;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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
    public void criarUsuario(@RequestBody @Valid PacienteDTO dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<PacienteDTOListagem> listaPaciente(@PageableDefault(size=10,sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(PacienteDTOListagem::new);
    }

    @PutMapping
    @Transactional
    public void updatePaciente(@RequestBody PacienteUpdateDTO dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.updateInfo(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void apagarPaciente(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }
}
