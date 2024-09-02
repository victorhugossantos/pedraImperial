package com.pedraimperial;
import java.util.Scanner;

import com.pedraimperial.menu.MoradorMenu;
import com.pedraimperial.menu.VeiculoMenu;
import com.pedraimperial.menu.VisitanteMenu;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            showMainMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Consumir uma nova linha apos o uso.

            switch (option) {
                case 1:
                    MoradorMenu.menuMorador(scanner);
                    break;
                case 2:
                    VeiculoMenu.menuVeiculos(scanner);
                    break;
                case 3:
                    VisitanteMenu.menuVisitantes(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do programa Gestao Condominial Pedra Imperial");
                    break;
                default: 
                    System.out.println("Opcao incorreta, tente novamente");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }
        // Metodo do menu principal

        private static void showMainMenu() {
            System.out.println("\n++++ Gestao Condominial Pedra Imperial ++++");
            System.out.println("1. Gerenciar Moradores");
            System.out.println("2. Gerenciar Veiculos");
            System.out.println("3. Gerenciar Visitantes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
        }


}

