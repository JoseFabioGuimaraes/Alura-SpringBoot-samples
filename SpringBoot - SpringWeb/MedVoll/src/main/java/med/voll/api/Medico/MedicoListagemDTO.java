package med.voll.api.Medico;

import med.voll.api.enums.Especialidade;

public record MedicoListagemDTO (Long id,String nome, String email, String crm, Especialidade especialidade) {

    public MedicoListagemDTO(Medico medico){
        this(medico.getId() ,medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getEspecialidade());
    }
}
