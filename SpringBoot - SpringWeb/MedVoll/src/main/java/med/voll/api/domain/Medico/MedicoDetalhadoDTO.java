package med.voll.api.domain.Medico;


import med.voll.api.domain.Endereco.Endereco;
import med.voll.api.domain.Medico.enums.Especialidade;

public record MedicoDetalhadoDTO(Long id, String nome, String email, String crm, String telefone , Especialidade especialidade, Endereco endereco) {
    public MedicoDetalhadoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(),medico.getTelefone() ,medico.getEspecialidade(), medico.getEndereco());
    }
}
