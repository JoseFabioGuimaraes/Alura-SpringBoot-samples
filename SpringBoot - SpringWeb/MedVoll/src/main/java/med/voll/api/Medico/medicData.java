package med.voll.api.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.Endereco.EnderecoDTO;
import med.voll.api.enums.Especialidade;

public record medicData(@NotBlank String nome,
                        @NotBlank @Email String email,
                        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
                        @NotNull Especialidade especialidade,
                        @NotNull @Valid EnderecoDTO endereco) {
}
