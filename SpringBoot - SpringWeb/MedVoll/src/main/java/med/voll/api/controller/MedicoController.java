package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.Medico.Medico;
import med.voll.api.Medico.MedicoListagemDTO;
import med.voll.api.Medico.MedicoRepository;
import med.voll.api.Medico.medicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void createMedic(@RequestBody @Valid medicData data){
        repository.save(new Medico(data));
    }

    @GetMapping
    public Page<MedicoListagemDTO> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(MedicoListagemDTO::new);
    }

}
