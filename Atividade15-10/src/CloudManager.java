import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Declaração da classe CloudManager que atua como o banco de dados em memória e motor financeiro da infraestrutura (RN02/RN04) - RA: 25362737-2
public class CloudManager {

    // Atributo bancoDeDados inicializado na declaração com HashMap associando cada Cliente a um Conjunto (Set) de Servidores sem duplicação (RN02) - RA: 25362737-2
    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    // Construtor padrão da classe CloudManager conforme especificado no Diagrama de Classes - RA: 25362737-2
    public CloudManager() {
    }

    // Método responsável por registrar um novo cliente no mapa, inicializando seu conjunto de servidores como um HashSet vazio (RN02) - RA: 25362737-2
    public void registrarCliente(Cliente c) {
        this.bancoDeDados.putIfAbsent(c, new HashSet<>());
    }

    // Método responsável por associar (provisionar) um servidor ao conjunto de servidores de um cliente registrado (RN02) - RA: 25362737-2
    public void provisionarServidor(Cliente c, Servidor s) {
        this.bancoDeDados.computeIfAbsent(c, k -> new HashSet<>()).add(s);
    }

    // Método que calcula a fatura ativa do cliente usando Streams API: filtra apenas servidores ligados, extrai o preço por hora e soma tudo (RN04) - RA: 25362737-2
    public double calcularFaturaAtiva(Cliente c) {
        return this.bancoDeDados.getOrDefault(c, Collections.emptySet()).stream()
                .filter(Servidor::isStatusLigado)
                .mapToDouble(Servidor::getPrecoPorHora)
                .sum();
    }

    // Método getter para acesso ao mapa do banco de dados caso necessário - RA: 25362737-2
    public Map<Cliente, Set<Servidor>> getBancoDeDados() {
        return bancoDeDados;
    }
}
