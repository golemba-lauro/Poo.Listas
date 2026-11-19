// Declaração da exceção customizada do tipo Checked (herda de Exception) para representar estouro do limite de memória RAM do servidor (RN03) - RA: 25362737-2
public class CapacidadeExcedidaException extends Exception {

    // Construtor que recebe a mensagem detalhada da falha de capacidade e a repassa para a superclasse Exception - RA: 25362737-2
    public CapacidadeExcedidaException(String msg) {
        super(msg);
    }
}
