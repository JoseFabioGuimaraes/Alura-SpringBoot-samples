package med.voll.api.domain.Paciente;

public record PacienteDTOListagem(String nome, String email, String cpf) {
    public PacienteDTOListagem(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
