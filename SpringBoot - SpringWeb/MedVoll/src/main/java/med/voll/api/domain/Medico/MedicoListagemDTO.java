package med.voll.api.domain.Medico;

import med.voll.api.domain.Medico.enums.Especialidade;

public record MedicoListagemDTO (Long id,String nome, String email, String crm, Especialidade especialidade) {

    public MedicoListagemDTO(Medico medico){
        this(medico.getId() ,medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getEspecialidade());
    }
}
