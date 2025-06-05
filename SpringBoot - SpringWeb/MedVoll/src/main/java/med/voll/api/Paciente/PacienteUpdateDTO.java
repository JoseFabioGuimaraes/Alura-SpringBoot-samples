package med.voll.api.Paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.Endereco.EnderecoDTO;

public record PacienteUpdateDTO(@NotNull Long id, String nome, String telefone, EnderecoDTO endereco) {
}
