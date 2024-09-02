package com.pedraimperial.menu;
import java.util.List;
import java.util.Scanner;

import com.pedraimperial.dao.MoradorDAO;
import com.pedraimperial.model.Morador;

public class MoradorMenu {
    
    public static void menuMorador(Scanner scanner){
        int option;

        do { 
            System.out.println("\n++++ Gerenciar Moradores ++++");
            System.out.println("1. Adicionar Morador");
            System.out.println("2. Buscar Morador por ID");
            System.out.println("3. Atualizar Morador");
            System.out.println("4. Deletar Morador");
            System.out.println("5. Listar Todos os Moradores");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opcao: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addMorador(scanner);
                    break;
                case 2:
                    searchMorador(scanner);
                    break;
                // case 3:
                //     updateMorador(scanner);
                //     break;
                case 4:
                    deleteMorador(scanner);
                    break;
                case 5:
                    listarMoradores();
                    break;
                case 0: 
                    System.out.println("Voltando ao menu principal");
                    break;
                default:
                    System.out.println("Opcao incorreta, tente novamente ");
                    break;
            }
        } while (option != 0);
    }

    private static void addMorador(Scanner scanner) {
        System.out.println("\n ++++ Adicionar Morador +++");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Bloco: ");
        String bloco = scanner.nextLine();
        System.out.print("Unidade: ");
        int unidade = scanner.nextInt();


        Morador morador = new Morador(nome, cpf, telefone, email, bloco, unidade);
        boolean sucesso = MoradorDAO.addMorador(morador);

        if(sucesso) {
            System.out.println("Morador adicionado com sucesso");
        } else {
            System.out.println("Falha ao adicionar morador.");
        }
    }

    private static void searchMorador(Scanner scanner) {
        System.out.println("\n++++ Buscar morador por id ++++");
        System.out.print("Digite o ID do morador: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Morador morador = MoradorDAO.getMoradorById(id);

        if (morador != null) {
            System.out.println("Morador encontrado: " + morador);
        } else {
            System.out.println("Morador nao encontrado. ");
        }
    }

    private static void deleteMorador(Scanner scanner) {

        System.out.println("\n ++++ Deletar morador ++++");
        System.out.print("Digite o ID do morador para deletar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean sucesso = MoradorDAO.deleteMorador(id);

        if (sucesso) {
            System.out.println("Morador deletado com sucesso");
        } else {
            System.out.println("Falha ao deletar morador.");
        }
    }

    private static void listarMoradores() {
        System.out.println("\n++++ Lista de todos os moradores ++++");
        List<Morador> moradores = MoradorDAO.getAllMoradores();

        if (moradores.isEmpty()) {
            System.out.println("Nenhum morador encontrado");
        } else {
            for (Morador morador: moradores) {
                System.out.println("ID: " + morador.getId());
                System.out.println("Nome: " + morador.getNome());
                System.out.println("CPF: " + morador.getCpf());
                System.out.println("Telefone: " + morador.getTelefone());
                System.out.println("Email: " + morador.getEmail());
                System.out.println("Bloco: " + morador.getBloco());
                System.out.println("Unidade: " + morador.getUnidade());
                System.out.println("-----------------------------"); 
            }
        }
    }
}
