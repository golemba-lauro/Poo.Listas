package br.com.starlog.main;

import br.com.starlog.dao.ProdutoDAO;
import br.com.starlog.dao.ProdutoDAOSqlite;
import br.com.starlog.model.Produto;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAOSqlite();

        System.out.println("=== 1. [CREATE] Cadastro de Produtos ===");
        Produto teclado = new Produto("Teclado Mecânico RGB", 349.90, 10);
        Produto mousepad = new Produto("Mousepad Speed XL", 89.90, 25);

        dao.salvar(teclado);
        dao.salvar(mousepad);

        System.out.println("ID gerado para Teclado Mecânico RGB: " + teclado.getId());
        System.out.println("ID gerado para Mousepad Speed XL: " + mousepad.getId());

        System.out.println("\n=== 2. [READ] Catálogo de Produtos ===");
        imprimirTabela(dao.listarTodos());

        System.out.println("\n=== 3. [UPDATE] Atualização do Teclado ===");
        teclado.setEstoque(15);
        teclado.setPreco(289.90);
        boolean atualizado = dao.atualizar(teclado);
        System.out.println("Retorno do método atualizar: " + atualizado);
        dao.buscarPorId(teclado.getId()).ifPresent(p -> System.out.println("Registro atualizado: " + p));

        System.out.println("\n=== 4. [DELETE] Exclusão de Produtos ===");
        boolean excluiuMousepad = dao.excluir(mousepad.getId());
        System.out.println("Exclusão do Mousepad (ID " + mousepad.getId() + "): " + excluiuMousepad);

        boolean excluiuInexistente = dao.excluir(888L);
        System.out.println("Tentativa de exclusão de ID inexistente (888L): " + excluiuInexistente + " (tratado sem travar)");

        System.out.println("\n=== 5. [FINAL STATE] Estado Final do Banco ===");
        List<Produto> restantes = dao.listarTodos();
        imprimirTabela(restantes);
        System.out.println("Total de produtos restantes no banco: " + restantes.size());
    }

    private static void imprimirTabela(List<Produto> produtos) {
        System.out.println("+------+------------------------------+-------------+------------+");
        System.out.printf("| %-4s | %-28s | %-11s | %-10s |%n", "ID", "NOME", "PREÇO", "ESTOQUE");
        System.out.println("+------+------------------------------+-------------+------------+");
        for (Produto p : produtos) {
            System.out.println(p);
        }
        System.out.println("+------+------------------------------+-------------+------------+");
    }
}
