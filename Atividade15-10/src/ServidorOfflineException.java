// Declaração da exceção customizada do tipo Unchecked (herda de RuntimeException) para representar erro de servidor desligado (RN03) - RA: 25362737-2
public class ServidorOfflineException extends RuntimeException {

    // Construtor que recebe a mensagem de erro e a repassa para a superclasse RuntimeException - RA: 25362737-2
    public ServidorOfflineException(String msg) {
        super(msg);
    }
}
