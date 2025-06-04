package med.voll.api.Medico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.Endereco.Endereco;
import med.voll.api.enums.Especialidade;

@Entity
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(medicData data) {
        this.nome = data.nome();
        this.email = data.email();
        this.crm = data.crm();
        this.especialidade= data.especialidade();
        this.endereco = new Endereco(data.endereco());
    }
}
