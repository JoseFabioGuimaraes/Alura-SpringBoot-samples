package med.voll.api.Medico;


import med.voll.api.Endereco.Endereco;
import med.voll.api.enums.Especialidade;

public record MedicoDetalhadoDTO(Long id, String nome, String email, String crm, String telefone , Especialidade especialidade, Endereco endereco) {
    public MedicoDetalhadoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(),medico.getTelefone() ,medico.getEspecialidade(), medico.getEndereco());
    }
}
