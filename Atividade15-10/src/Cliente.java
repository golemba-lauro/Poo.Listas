import java.util.Objects;

// Declaração da classe Cliente que representa a entidade contratante dos serviços em nuvem - RA: 25362737-2
public class Cliente {

    // Atributos privados para garantir o encapsulamento rigoroso dos dados do cliente (RN01) - RA: 25362737-2
    private String cpf;
    private String nome;

    // Construtor que inicializa o cliente com seu CPF e nome empresarial ou pessoal - RA: 25362737-2
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Método getter para retornar o CPF do cliente - RA: 25362737-2
    public String getCpf() {
        return cpf;
    }

    // Método setter para atualizar o CPF do cliente caso necessário - RA: 25362737-2
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Método getter para retornar o nome do cliente - RA: 25362737-2
    public String getNome() {
        return nome;
    }

    // Método setter para atualizar o nome do cliente caso necessário - RA: 25362737-2
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Sobrescrita do método equals para definir a regra de identidade lógica: dois clientes são iguais se possuem o mesmo CPF (RN01) - RA: 25362737-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cliente outro = (Cliente) obj;
        return Objects.equals(this.cpf, outro.cpf);
    }

    // Sobrescrita do método hashCode consistente com o equals, calculando o código hash a partir do CPF para uso como chave no HashMap (RN01/RN02) - RA: 25362737-2
    @Override
    public int hashCode() {
        return Objects.hash(this.cpf);
    }
}
