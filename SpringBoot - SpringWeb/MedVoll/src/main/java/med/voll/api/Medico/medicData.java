package med.voll.api.Medico;

import med.voll.api.Endereco.EnderecoDTO;
import med.voll.api.enums.Especialidade;

public record medicData(String nome, String email, String crm, Especialidade especialidade, EnderecoDTO endereco) {
}
