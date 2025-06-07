package med.voll.api.domain.Paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.Endereco.EnderecoDTO;

public record PacienteDTO(@NotBlank String nome,
                          @NotBlank @Email String email,
                          @NotBlank String telefone,
                          @NotBlank @Pattern(regexp = "\\d{11}")String cpf,
                          @NotNull @Valid EnderecoDTO endereco) {
}
