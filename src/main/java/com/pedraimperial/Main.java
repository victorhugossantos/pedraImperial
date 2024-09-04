package com.pedraimperial;
import java.util.Scanner;

import com.pedraimperial.menu.MoradorMenu;
import com.pedraimperial.menu.VeiculoMenu;
import com.pedraimperial.menu.VisitanteMenu;

public class Main {
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            int option;
            
            do {
                showMainMenu();
                option = scanner.nextInt();
                
                switch (option) {
                    case 1 -> MoradorMenu.menuMorador(scanner);
                    case 2 -> VeiculoMenu.menuVeiculos(scanner);
                    case 3 -> VisitanteMenu.menuVisitantes(scanner);
                    case 0 -> System.out.println("Saindo do programa Gestao Condominial Pedra Imperial");
                    default -> System.out.println("Opcao incorreta, tente novamente");
                }
            } while (option != 0);
        }
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

