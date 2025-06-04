package med.voll.api.Endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.cep = endereco.cep();
        this.bairro= endereco.bairro();
        this.numero= endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizarInformacoes(EnderecoDTO dados) {
        if(dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }
        if(dados.cep() != null){
            this.cep = dados.cep();
        }
        if(dados.bairro() != null){
            this.bairro= dados.bairro();
        }
        if(dados.numero() != null){
            this.numero= dados .numero();
        }
        if(dados.complemento() != null){
            this.complemento = dados.complemento();
        }
        if(dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if (dados.uf() != null){
            this.uf = dados.uf();
        }

    }
}
