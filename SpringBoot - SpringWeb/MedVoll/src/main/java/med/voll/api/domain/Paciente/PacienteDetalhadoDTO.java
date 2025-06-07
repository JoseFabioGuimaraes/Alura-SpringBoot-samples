package med.voll.api.domain.Paciente;

import med.voll.api.domain.Endereco.Endereco;

public record   PacienteDetalhadoDTO (Long id, String nome, String email, String telefone, String cpf,
                                      Endereco endereco){
    public PacienteDetalhadoDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(),paciente.getTelefone(), paciente.getCpf(),
                paciente.getEndereco());
    }
}
