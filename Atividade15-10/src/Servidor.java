import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Declaração da classe Servidor responsável por gerenciar recursos de hardware e hospedar containers (RN01/RN02/RN03/RN04) - RA: 25362737-2
public class Servidor {

    // Atributos privados do servidor encapsulando IP, preço por hora, RAM total e status de funcionamento (RN01) - RA: 25362737-2
    private String ip;
    private double precoPorHora;
    private double ramTotal;
    private boolean statusLigado;

    // Lista cronológica de containers inicializada diretamente na declaração como ArrayList para evitar NullPointerException (RN02) - RA: 25362737-2
    private List<Container> containers = new ArrayList<>();

    // Construtor do Servidor que recebe IP, RAM total e preço por hora, iniciando o servidor desligado por padrão - RA: 25362737-2
    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip;
        this.ramTotal = ramTotal;
        this.precoPorHora = precoPorHora;
        this.statusLigado = false;
    }

    // Método que altera o estado do servidor para ligado (true), permitindo a alocação de containers - RA: 25362737-2
    public void ligar() {
        this.statusLigado = true;
    }

    // Método que altera o estado do servidor para desligado (false) - RA: 25362737-2
    public void desligar() {
        this.statusLigado = false;
    }

    // Método que aloca um container no servidor aplicando a política Fail-Fast para validar status e capacidade de RAM (RN03) - RA: 25362737-2
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {
        // Regra de Status (Unchecked): verifica se o servidor está desligado e lança ServidorOfflineException (RN03.1) - RA: 25362737-2
        if (!this.statusLigado) {
            throw new ServidorOfflineException("Erro: Não é possível alocar containers em um servidor desligado.");
        }

        // Regra de Capacidade (Checked): verifica se a RAM necessária somada à RAM em uso ultrapassa a RAM total do servidor (RN03.2) - RA: 25362737-2
        if (this.calcularRamEmUso() + c.getRamNecessaria() > this.ramTotal) {
            throw new CapacidadeExcedidaException("Falha Crítica: Memória RAM insuficiente no servidor " + this.ip + ".");
        }

        // Adiciona o container na lista cronológica interna caso passe por todas as barreiras de validação - RA: 25362737-2
        this.containers.add(c);
    }

    // Método que calcula o total de RAM em uso utilizando exclusivamente a Streams API com mapToDouble e sum (RN04) - RA: 25362737-2
    public double calcularRamEmUso() {
        return this.containers.stream()
                .mapToDouble(Container::getRamNecessaria)
                .sum();
    }

    // Método getter para retornar o endereço IP do servidor - RA: 25362737-2
    public String getIp() {
        return ip;
    }

    // Método setter para atualizar o endereço IP do servidor - RA: 25362737-2
    public void setIp(String ip) {
        this.ip = ip;
    }

    // Método getter para retornar o preço por hora do servidor - RA: 25362737-2
    public double getPrecoPorHora() {
        return precoPorHora;
    }

    // Método setter para atualizar o preço por hora do servidor - RA: 25362737-2
    public void setPrecoPorHora(double precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    // Método getter para retornar a capacidade total de memória RAM do servidor - RA: 25362737-2
    public double getRamTotal() {
        return ramTotal;
    }

    // Método setter para atualizar a capacidade total de memória RAM do servidor - RA: 25362737-2
    public void setRamTotal(double ramTotal) {
        this.ramTotal = ramTotal;
    }

    // Método getter para verificar se o servidor está ligado ou desligado - RA: 25362737-2
    public boolean isStatusLigado() {
        return statusLigado;
    }

    // Método getter para acessar a lista de containers alocados no servidor - RA: 25362737-2
    public List<Container> getContainers() {
        return containers;
    }

    // Sobrescrita do método equals definindo que dois servidores são iguais se possuem o mesmo endereço IP (RN01) - RA: 25362737-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Servidor outro = (Servidor) obj;
        return Objects.equals(this.ip, outro.ip);
    }

    // Sobrescrita do método hashCode baseado no atributo IP para garantir unicidade correta no Set de servidores (RN01/RN02) - RA: 25362737-2
    @Override
    public int hashCode() {
        return Objects.hash(this.ip);
    }
}
