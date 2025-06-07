package med.voll.api.domain.Paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.Endereco.EnderecoDTO;

public record PacienteUpdateDTO(@NotNull Long id, String nome, String telefone, EnderecoDTO endereco) {
}
