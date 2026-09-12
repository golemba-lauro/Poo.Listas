package br.com.meusistema.main;

import br.com.meusistema.model.Carro;

public class Sistema {
    public static void main(String[] args) {
        System.out.println("Iniciando o sistema...");

        Carro meuCarro = new Carro();
        meuCarro.modelo = "Fusca";
        meuCarro.cor = "Azul";
        meuCarro.buzinar();

        Carro segundoCarro = new Carro();
        segundoCarro.modelo = "Uno";
        segundoCarro.cor = "Vermelho";
        segundoCarro.buzinar();
    }
}