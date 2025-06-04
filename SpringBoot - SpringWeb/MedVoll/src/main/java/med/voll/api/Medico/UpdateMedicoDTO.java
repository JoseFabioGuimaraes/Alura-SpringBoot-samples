package med.voll.api.Medico;


import jakarta.validation.constraints.NotNull;
import med.voll.api.Endereco.EnderecoDTO;

public record UpdateMedicoDTO(@NotNull Long id,
                              String nome,
                              String telefone,
                              EnderecoDTO endereco) {
}
