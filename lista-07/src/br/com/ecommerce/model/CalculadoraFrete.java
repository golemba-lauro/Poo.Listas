package br.com.ecommerce.model;

import br.com.ecommerce.exception.TipoFreteInvalidoException;

public class CalculadoraFrete {
    
    public double processarFrete(double valorDoPedido, EstrategiaFrete estrategia){
        if (estrategia == null){
            throw new TipoFreteInvalidoException("Tipo de frete invalido!");
        }
        return estrategia.calcular(valorDoPedido);
    }

}
