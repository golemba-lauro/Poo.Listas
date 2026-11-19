import java.util.Objects;

// Declaração da classe Container que representa uma aplicação isolada executada dentro de um servidor - RA: 25362737-2
public class Container {

    // Atributos privados aplicando o encapsulamento rigoroso para id, nome da aplicação e memória RAM necessária (RN01) - RA: 25362737-2
    private String id;
    private String nomeApp;
    private double ramNecessaria;

    // Construtor responsável por instanciar um Container com seu identificador, nome da aplicação e consumo de RAM - RA: 25362737-2
    public Container(String id, String nomeApp, double ramNecessaria) {
        this.id = id;
        this.nomeApp = nomeApp;
        this.ramNecessaria = ramNecessaria;
    }

    // Método getter para obter o identificador único do container - RA: 25362737-2
    public String getId() {
        return id;
    }

    // Método setter para atualizar o identificador do container - RA: 25362737-2
    public void setId(String id) {
        this.id = id;
    }

    // Método getter para obter o nome da aplicação que roda no container - RA: 25362737-2
    public String getNomeApp() {
        return nomeApp;
    }

    // Método setter para atualizar o nome da aplicação do container - RA: 25362737-2
    public void setNomeApp(String nomeApp) {
        this.nomeApp = nomeApp;
    }

    // Método getter para obter a quantidade de memória RAM exigida pelo container - RA: 25362737-2
    public double getRamNecessaria() {
        return ramNecessaria;
    }

    // Método setter para atualizar a quantidade de memória RAM necessária - RA: 25362737-2
    public void setRamNecessaria(double ramNecessaria) {
        this.ramNecessaria = ramNecessaria;
    }

    // Sobrescrita do método equals definindo que dois containers são iguais quando possuem o mesmo ID lógico (RN01) - RA: 25362737-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Container outro = (Container) obj;
        return Objects.equals(this.id, outro.id);
    }

    // Sobrescrita do método hashCode gerando o hash exclusivamente a partir do atributo id do container (RN01) - RA: 25362737-2
    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
