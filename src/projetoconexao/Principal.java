package projetoconexao;

import java.util.Scanner;

public class Principal {

    static Controle control = new Controle();
    static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {

        boolean x = true;
        while (x) {
            System.err.print("Bem-vindo ao sistema.\n"
                    + " -------------------------------------------\n"
                    + "| Aperte (1) para cadastrar um livro.       |\n"
                    + "| Aperte (2) para listar os livros.         |\n"
                    + "| Aperte (0) para sair do sistema.          |\n"
                    + " -------------------------------------------\n"
                    + "> ");

            int resp = leia.nextInt();

            switch (resp) {

                case 1:
                    control.cadastrarLivro();
                    loop();
                    break;
                case 2:
                    control.adicionaArray();
                    loop();
                    break;
                case 0:
                    System.exit(0);
                    loop();
                    break;
                default:
                    System.out.println("Digite um número válido.");
                    ;

            }
        }

    }

    static void loop() {
        System.out.println("\nDeseja executar o sistema novamente? (sim/nao)");
        String resp = leia.next();

        if (resp.equalsIgnoreCase("NAO")) {
            System.exit(0);
        }
    }
}
