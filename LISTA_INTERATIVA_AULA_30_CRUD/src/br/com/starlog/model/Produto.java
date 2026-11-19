package br.com.starlog.model;

public class Produto {

    private Long id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(Long id, String nome, double preco, int estoque) {
        if (nome == null || nome.trim().length() < 3) {
            throw new IllegalArgumentException("O nome do produto não pode ser nulo ou ter menos de 3 caracteres.");
        }
        if (preco <= 0.0) {
            throw new IllegalArgumentException("O preço deve ser estritamente maior que zero.");
        }
        if (estoque < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        }

        this.id = id;
        this.nome = nome.trim();
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(String nome, double preco, int estoque) {
        this(null, nome, preco, estoque);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0.0) {
            throw new IllegalArgumentException("O preço deve ser estritamente maior que zero.");
        }
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        }
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-28s | R$ %8.2f | %7d un |",
                id != null ? id : 0L, nome, preco, estoque);
    }
}
