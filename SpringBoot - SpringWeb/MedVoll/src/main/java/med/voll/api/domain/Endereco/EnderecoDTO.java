package med.voll.api.domain.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(@NotBlank String logradouro,
                          @NotBlank String bairro,
                          @NotBlank @Pattern(regexp = "\\d{8}") String cep,
                          @NotBlank String cidade,
                          @NotBlank String uf,
                          String complemento,
                          String numero) {
}
