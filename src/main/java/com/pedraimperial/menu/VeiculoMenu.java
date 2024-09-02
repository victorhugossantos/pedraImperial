package com.pedraimperial.menu;

import java.util.Scanner;

public class VeiculoMenu {
    public static void menuVeiculos(Scanner scanner) {
        int option;

        do { 
            System.out.println("\n++++ Gerenciar Veiculos ++++");
            System.out.println("1. Adicionar Veiculo");
            System.out.println("2. Buscar veiculo por placa");
            System.out.println("3. Atualizar Veiculo");
            System.out.println("4. Deletar Veiculo");
            System.out.println("5. Listar todos os veiculos");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opcao: ");
            
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addVeiculo(scanner);
                    break;
                case 2:
                    searchVeiculo(scanner);
                    break;
                case 3: 
                    updateVeiculo(scanner);
                    break;
                case 4: 
                    deleteVeiculo(scanner);
                    break;
                case 5:
                    listarVeiculos(scanner);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal.");
                    break;

                default:
                    System.out.println("Opcao incorreta, tente novamente");
                    break;
            }

        } while (option != 0);
    }

}
