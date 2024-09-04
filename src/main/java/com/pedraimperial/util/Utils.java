package com.pedraimperial.util;

public class Utils {
    public static void clearConsole(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para linux e mac
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // se falhar, imprime varias linhas para limpar a tela
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
}
