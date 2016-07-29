package projetoconexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controle {

    Scanner leia = new Scanner(System.in);
    List<Livro> Livros = new ArrayList<Livro>();

    void adicionaArray() {
        try {
            Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM LIVROS");

            while (rs.next()) {
                Livro livro = new Livro();
                livro.id = rs.getInt("id");
                livro.titulo = rs.getString("titulo");
                livro.autor = rs.getString("autor");
                livro.preco = rs.getDouble("preco");
                Livros.add(livro);
            }

        } catch (SQLException e) {
            System.out.println("ERRO NO SQL");
        }
    }

    void cadastrarLivro() {
        try {
            Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();

            String sql;

            String x = "sim";

            while (x.equalsIgnoreCase("sim")) {

                System.out.println("Qual o nome do livro?");
                String titulo = leia.nextLine();
                System.out.println("Qual o nome do autor desse livro?");
                String autor = leia.nextLine();
                System.out.println("Qual o preço desse livro?");
                double preco = leia.nextInt();

                sql = "INSERT INTO `livro` (`titulo`, `autor`, `preço`)"
                        + "VALUES ('" + titulo + "', " + autor + ", '" + preco + "')";
                stmt.executeUpdate(sql);
            }

            System.out.println("Deseja cadastrar outro livro? (sim/nao)");
            x = leia.next();

        } catch (SQLException e) {
            System.out.println("ERRO NO SQL");
        }
    }

    void listaLivros() {
        for (Livro l : Livros) {
            System.out.println("Código: " + l.id + "\n"
                    + "Título:  " + l.titulo + "\n"
                    + "Autor:   " + l.autor + "\n"
                    + "Preço:   " + l.preco + "\n");
        }
    }
}
