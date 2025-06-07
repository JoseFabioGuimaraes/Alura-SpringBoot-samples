package med.voll.api.domain.Medico;

import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public Medico createMedico(Medico medico){
        return repository.save(medico);
    }
}
