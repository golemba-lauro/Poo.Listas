package br.com.ecommerce.main;

import br.com.ecommerce.exception.TipoFreteInvalidoException;
import br.com.ecommerce.model.CalculadoraFrete;
import br.com.ecommerce.model.FreteMotoboy;
import br.com.ecommerce.model.FretePac;
import br.com.ecommerce.model.FreteSedex;

public class MainTeste {
    public static void main(String[] args){
        
        CalculadoraFrete calculadora = new CalculadoraFrete();

        try{
            System.out.println("Sedex: " + calculadora.processarFrete(100.00, new FreteSedex()));
            System.out.println("PAC: " + calculadora.processarFrete(100.00, new FretePac()));
            System.out.println("Motoboy: " + calculadora.processarFrete(100.00, new FreteMotoboy()));
            System.out.println("Invalido: " + calculadora.processarFrete(100.00, null));
        }catch (TipoFreteInvalidoException e){
            System.out.println("Erro capturado: " + e.getMessage());
        }
    }
}
