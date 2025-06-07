package med.voll.api.domain.Medico;


import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.Endereco.EnderecoDTO;

public record UpdateMedicoDTO(@NotNull Long id,
                              String nome,
                              String telefone,
                              EnderecoDTO endereco) {
}
