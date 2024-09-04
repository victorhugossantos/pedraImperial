package com.pedraimperial.menu;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import com.pedraimperial.dao.MoradorDAO;
import com.pedraimperial.dao.VisitanteDAO;
import com.pedraimperial.model.Morador;
import com.pedraimperial.model.Visitante;

public class VisitanteMenu {
    public static void menuVisitantes(Scanner scanner) {

        int option;

        do {
            System.out.println("\n++++ Gerenciar Visitantes ++++");
            System.out.println("1. Adicionar Visitante");
            System.out.println("2. Buscar Visitante por Id");
            System.out.println("3. Listar todos os Visitantes");
            System.out.println("4. Registrar saida de Visitante");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opcao: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addVisitante(scanner);
                case 2 -> searchVisitante(scanner);
                case 3 -> listarVisitantes();
                case 4 -> registrarSaidaVisitante(scanner);
                case 0 -> System.out.println("Voltando ao menu principal");
                default -> System.out.println("Opcao incorreta, tente novamente.");
            } 
        } while (option != 0);
    }

    private static void addVisitante(Scanner scanner) {
        System.out.println("\n++++ Adicionar Visitante ++++");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("ID do Morador: ");
        int idMorador = scanner.nextInt();
        // registrar a hora atual
        Timestamp dataEntrada = new Timestamp(System.currentTimeMillis());

        Visitante visitante = new Visitante(nome, cpf, dataEntrada, idMorador);
        boolean sucesso = VisitanteDAO.addVisitante(visitante);

        if(sucesso) {
            System.out.println("Visitante adicionado com sucesso");
        } else {
            System.out.println("Erro ao adicionar visitante");
        }
    }

    private static void searchVisitante(Scanner scanner) {
        System.out.println("\n++++ Buscar Visitante por Id ++++");
        System.out.print("Digite o ID do visitante: ");

        int id = scanner.nextInt();
        
        Visitante visitante = VisitanteDAO.getVisitanteById(id);

        if (visitante != null) {
                Morador morador = MoradorDAO.getMoradorByID(visitante.getIdMorador());
                System.out.println("-----------------------------");
                System.out.println("ID: " + visitante.getId()); 
                System.out.println("Nome: " + visitante.getNome());
                System.out.println("CPF: " + visitante.getCpf());
                System.out.println("Data de Entrada: " + visitante.getDataEntrada());
                System.out.println("Data de Saida: " + visitante.getDataSaida());
                System.out.println("Nome do Morador: " + morador.getNome());
                System.out.println("Bloco: " + morador.getBloco());
                System.out.println("Unidade: " + morador.getUnidade());
                System.out.println("-----------------------------"); 
        } else {
            System.out.println("Nenhum visitante com ID fornecido foi encontrado");
        }
    }

    private static void listarVisitantes() {
        System.out.println("\n++++ Listando todos os visitantes ++++");

        List<Visitante> visitantes = VisitanteDAO.getAllVisitantes();

        if(visitantes != null && !visitantes.isEmpty()){
            for (Visitante visitante : visitantes) {
                Morador morador = MoradorDAO.getMoradorByID(visitante.getIdMorador());
                System.out.println("-----------------------------"); 
                System.out.println("ID: " + visitante.getId()); 
                System.out.println("Nome: " + visitante.getNome());
                System.out.println("CPF: " + visitante.getCpf());
                System.out.println("Data de Entrada: " + visitante.getDataEntrada());
                System.out.println("Data de Saida: " + visitante.getDataSaida());
                System.out.println("Nome do Morador: " + morador.getNome());
                System.out.println("Bloco: " + morador.getBloco());
                System.out.println("Unidade: " + morador.getUnidade());
                System.out.println("-----------------------------"); 
            }
        } else {
            System.out.println("Nenhum visitante encontrada na data informada");
        }

    }

    private static void registrarSaidaVisitante(Scanner scanner) {
        System.out.println("\n++++ Registra Saida do Visitante ++++");
        System.out.print("Informe o ID do Visitante: ");

        int id = scanner.nextInt();

        boolean sucesso = VisitanteDAO.registraSaidaVisitante(id);

        if(sucesso) {
            System.out.println("Saida do visitante registrada com sucesso");
        } else {
            System.out.println("Erro ao registrar saida do visitante");
        }
    }

}
