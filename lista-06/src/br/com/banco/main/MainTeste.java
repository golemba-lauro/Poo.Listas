package br.com.banco.main;

import br.com.banco.model.Agencia;
import br.com.banco.model.Cliente;
import br.com.banco.model.ContaBancaria;


public class MainTeste {
    public static void main(String[] args){
        Cliente cliente1 = new Cliente("111.222.333-44", "Ana", "ana@email.com");
        Cliente cliente2 = new Cliente("111.222.333-44", "Beatriz", "beatriz@email.com");
   
        if(cliente1.equals(cliente2)){
            System.out.println("Os clientes sao iguais!");
        } else {
            System.out.println("Os clientes sao diferentes!");
        }
        
        ContaBancaria conta = new ContaBancaria("001", cliente1, 50.0);

        boolean resultado = conta.sacar(50.0);

        System.out.println("Saque realizado? " + resultado);

        System.out.println("Total de contas abertas: " + Agencia.getTotalContasAbertas());
   
    }
}
    
