package br.com.cybercorp.main;

import br.com.cybercorp.model.Credencial;
import br.com.cybercorp.model.Departamento;
import br.com.cybercorp.model.Funcionario;
import br.com.cybercorp.model.SistemaSeguranca;
import br.com.cybercorp.model.Veiculo;

public class MainTeste {
    public static void main(String[] args){
    Departamento depto = new Departamento("TI", "Tecnologia da Informacao", 3);
    Funcionario func = new Funcionario("M001", "Lauro", depto);
    Veiculo carro = new Veiculo("ABC-1234", "Fusca", func);

    SistemaSeguranca sistema = new SistemaSeguranca(2);

    Credencial c1 = new Credencial("FFF-999", true, func);
    Credencial clone = new Credencial("FFF-999", true, func);

    //-------------------------------------------------------------------------------
    System.out.println("--- TESTE DA CATRACA ---");
    sistema.registrarCatraca(func);
    sistema.registrarCatraca(func);

    //-------------------------------------------------------------------------------
    System.out.println("--- TESTE DO COFRE ---");
    sistema.acessarCofre(c1);
    sistema.acessarCofre(clone);

    //------------------------------------------------------------------------------
    System.out.println("--- TESTE DA GARAGEM ---");
    sistema.estacionarVeiculo(carro, 0);
    sistema.estacionarVeiculo(carro, 5);


    }
}
