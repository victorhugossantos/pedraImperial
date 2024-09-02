package com.pedraimperial.menu;
import java.util.Scanner;

public class VisitanteMenu {
    public static void menuVisitantes(Scanner scanner) {

        int option;

        do {
            System.out.println("\n++++ Gerenciar Visitantes ++++");
            System.out.println("1. Adicionar Visitante");
            System.out.println("2. Buscar Visitante por Id");
            System.out.println("3. Deletar Visitante");
            System.out.println("4. Listar todos os Visitantes");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opcao incorreta, tente novamente");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addVisitante(scanner);
                    break;
                case 2:
                    searchVisitante(scanner);
                    break;
                case 3: 
                    deleteVisitante(scanner);
                    break;
                case 4: 
                    listarVisitantes(scanner);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal");
                    break;
                default:
                    System.out.println("Opcao incorreta, tente novamente.");
                    break;
            } 
        } while (option != 0);
    }
}
