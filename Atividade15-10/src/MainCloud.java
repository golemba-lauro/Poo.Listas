// Declaração da classe executável MainCloud para realização do roteiro oficial de testes do sistema NexusCloud Manager - RA: 25362737-2
public class MainCloud {

    // Método principal (ponto de entrada da aplicação Java) que executa os 10 passos do campo de testes - RA: 25362737-2
    public static void main(String[] args) {

        // Passo 1: Instancia o gerenciador principal CloudManager - RA: 25362737-2
        CloudManager manager = new CloudManager();

        // Passo 2: Instancia 1 Cliente com CPF "111.222.333-44" e nome "Wayne Enterprises" - RA: 25362737-2
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");

        // Passo 3: Instancia 1 Servidor com IP "192.168.0.1", RAM Total de 16.0 GB e Preço por Hora de R$ 5.50 - RA: 25362737-2
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);

        // Passo 4: Registra o cliente no banco de dados do CloudManager e provisiona o servidor para ele - RA: 25362737-2
        manager.registrarCliente(cliente);
        manager.provisionarServidor(cliente, servidor);

        // Passo 5: Instancia 2 Containers diferentes ("C-01" com 10.0 GB de RAM e "C-02" com 8.0 GB de RAM) - RA: 25362737-2
        Container container1 = new Container("C-01", "App-01", 10.0);
        Container container2 = new Container("C-02", "App-02", 8.0);

        // Passo 6: Teste de Falha Unchecked (ServidorOfflineException ao tentar alocar com servidor desligado), comentado conforme pede o Passo 7 - RA: 25362737-2
        // servidor.alocarContainer(container1);

        // Passo 7: Liga o servidor após comentar a linha do Passo 6 para o programa prosseguir normalmente - RA: 25362737-2
        servidor.ligar();

        // Passos 8 e 9: Aloca o Container 1 com sucesso e tenta alocar o Container 2 dentro de um bloco try-catch para capturar CapacidadeExcedidaException - RA: 25362737-2
        try {
            // Passo 8: Aloca o Container 1 (10.0 GB) com sucesso no servidor ligado (limite 16.0 GB) - RA: 25362737-2
            servidor.alocarContainer(container1);

            // Passo 9: Tenta alocar o Container 2 (8.0 GB), totalizando 18.0 GB e estourando o limite de 16.0 GB do servidor - RA: 25362737-2
            servidor.alocarContainer(container2);
        } catch (CapacidadeExcedidaException e) {
            // Captura a exceção Checked CapacidadeExcedidaException e imprime a mensagem de erro de forma elegante no console - RA: 25362737-2
            System.out.println(e.getMessage());
        }

        // Passo 10: Imprime no console o valor retornado por calcularFaturaAtiva do CloudManager (valor esperado: 5.50) - RA: 25362737-2
        System.out.println(manager.calcularFaturaAtiva(cliente));
    }
}
