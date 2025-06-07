package med.voll.api.domain.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.Endereco.EnderecoDTO;
import med.voll.api.domain.Medico.enums.Especialidade;

public record medicData(@NotBlank String nome,
                        @NotBlank @Email String email,
                        @NotBlank String telefone,
                        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
                        @NotNull Especialidade especialidade,
                        @NotNull @Valid EnderecoDTO endereco) {
}
