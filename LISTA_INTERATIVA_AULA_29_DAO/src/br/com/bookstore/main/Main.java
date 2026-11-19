package br.com.bookstore.main;

import br.com.bookstore.dao.LivroDAO;
import br.com.bookstore.dao.LivroDAOSqlite;
import br.com.bookstore.model.Livro;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LivroDAO dao = new LivroDAOSqlite();

        Livro l1 = new Livro("Clean Code", "Robert C. Martin", 129.90);
        Livro l2 = new Livro("Design Patterns", "Erich Gamma et al.", 159.50);
        Livro l3 = new Livro("Refactoring", "Martin Fowler", 142.00);

        dao.salvar(l1);
        dao.salvar(l2);
        dao.salvar(l3);

        System.out.println("Livros salvos com IDs gerados:");
        System.out.println("ID 1 -> " + l1.getId());
        System.out.println("ID 2 -> " + l2.getId());
        System.out.println("ID 3 -> " + l3.getId());

        System.out.println("\nConsulta pelo ID 2:");
        dao.buscarPorId(2L).ifPresentOrElse(
            livro -> System.out.println("Livro encontrado: " + livro),
            () -> System.out.println("Aviso: Livro com ID 2 não encontrado.")
        );

        System.out.println("\nConsulta pelo ID 999 (inexistente):");
        dao.buscarPorId(999L).ifPresentOrElse(
            livro -> System.out.println("Livro encontrado: " + livro),
            () -> System.out.println("Aviso: Livro com ID 999 não encontrado no catálogo.")
        );

        System.out.println("\nCatálogo Completo de Livros:");
        System.out.println("+------+---------------------------+---------------------------+-------------+");
        System.out.printf("| %-4s | %-25s | %-25s | %-11s |%n", "ID", "TÍTULO", "AUTOR", "PREÇO");
        System.out.println("+------+---------------------------+---------------------------+-------------+");
        List<Livro> todos = dao.listarTodos();
        for (Livro livro : todos) {
            System.out.println(livro);
        }
        System.out.println("+------+---------------------------+---------------------------+-------------+");
    }
}
