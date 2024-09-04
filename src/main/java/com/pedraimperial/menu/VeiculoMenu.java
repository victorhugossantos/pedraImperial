package com.pedraimperial.menu;

import java.util.Scanner;

import com.pedraimperial.dao.MoradorDAO;
import com.pedraimperial.dao.VeiculoDAO;
import com.pedraimperial.model.Morador;
import com.pedraimperial.model.Veiculo;

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
                case 1 -> addVeiculo(scanner);
                case 2 -> searchVeiculo(scanner);
                case 3 -> updateVeiculo(scanner);
                case 4 -> deleteVeiculo(scanner);
                case 5 -> listarVeiculos(scanner);
                case 0 -> System.out.println("Voltando ao Menu Principal.");

                default -> System.out.println("Opcao incorreta, tente novamente");
            }

        } while (option != 0);
    }

    private static void addVeiculo(Scanner scanner){
        System.out.println("\n ++++ Adicionar Veiculo ++++");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        System.out.print("ID do Morador: ");
        int idMorador = scanner.nextInt();
        scanner.nextLine();

        Veiculo veiculo = new Veiculo(placa, modelo, cor, idMorador);
        boolean sucesso = VeiculoDAO.addVeiculo(veiculo);

        if(sucesso) {
            System.out.println("Veiculo adicionado com sucesso");
        } else {
            System.out.println("Erro ao adicionar veiculo");
        }
    }

    private static void updateVeiculo(Scanner scanner) {
        System.out.println("\n ++++ Atualizar Veiculo ++++");
        System.out.print("Placa do veiculo a ser atualizada: ");
        String placa = scanner.nextLine();

        Veiculo veiculo = VeiculoDAO.getVeiculoByPlaca(placa);

        if (veiculo != null) {
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Cor: ");
            String cor = scanner.nextLine();
            System.out.print("ID do Morador: ");
            int idMorador = scanner.nextInt();

            veiculo.setModelo(modelo);
            veiculo.setCor(cor);
            veiculo.setIdMorador(idMorador);

            boolean sucesso = VeiculoDAO.updateVeiculo(veiculo);

            if(sucesso) {
                System.out.println("Veiculo atualizado com sucesso");
            } else {
                System.out.println("Erro ao atualizar veiculo");
            }
        } else {
            System.out.println("Nenhum veiculo encontrado com a placa informada");
        }
    }

    private static void deleteVeiculo(Scanner scanner) {
        System.out.println("\n++++ Deletar Veiculo ++++");
        System.out.print("Placa do veiculo: ");
        String placa = scanner.nextLine();

        boolean sucesso = VeiculoDAO.deleteVeiculo(placa);
        if (sucesso) {
            System.out.println("Veiculo deletado com sucesso");
        } else {
            System.out.println("Erro ao deletar veiculo");
        }
    }

    private static void listarVeiculos(Scanner scanner) {
        System.out.println("\n++++ Listando todos os veiculos ++++");

        var veiculos = VeiculoDAO.getAllVeiculos();

        if(veiculos != null && !veiculos.isEmpty()) {
            for(Veiculo veiculo : veiculos) {
                Morador morador = MoradorDAO.getMoradorByID(veiculo.getIdMorador());
                System.out.println("-----------------------------"); 
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Modelo: " + veiculo.getModelo());
                System.out.println("Cor: " + veiculo.getCor());
                System.out.println("Proprietario: " + morador.getNome());
                System.out.println("Bloco: " + morador.getBloco());
                System.out.println("Unidade: " + morador.getUnidade());
                System.out.println("-----------------------------"); 
            }
        } else {
            System.out.println("Nenhum veiculo encontrado");
        }
    }

    private static void searchVeiculo(Scanner scanner) {
        System.out.println("\n++++ Buscar veiculo por Placa ++++");
        System.out.print("Digite a placa do veiculo: ");
        String placa = scanner.nextLine();

        Veiculo veiculo = VeiculoDAO.getVeiculoByPlaca(placa);

        if (veiculo != null) {
            Morador morador = MoradorDAO.getMoradorByID(veiculo.getIdMorador());
            System.out.println("-----------------------------"); 
            System.out.println("Placa: " + veiculo.getPlaca());
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Cor: " + veiculo.getCor());
            System.out.println("Proprietario: " + morador.getNome());
            System.out.println("Bloco: " + morador.getBloco());
            System.out.println("Unidade: " + morador.getUnidade());
            System.out.println("-----------------------------"); 

        } else {
            System.out.println("Veiculo com a placa: " + placa + "nao encontrado");
        }
    }
}
