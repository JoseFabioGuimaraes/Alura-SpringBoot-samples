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
    private String telefone;
    private String crm;
    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(medicData data) {
        this.ativo = true;
        this.nome = data.nome();
        this.telefone = data.telefone();
        this.email = data.email();
        this.crm = data.crm();
        this.especialidade= data.especialidade();
        this.endereco = new Endereco(data.endereco());
    }

    public void atualizarInformacoes(UpdateMedicoDTO dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
