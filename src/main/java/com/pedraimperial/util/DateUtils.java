package com.pedraimperial.util;
 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateUtils {
    public static LocalDate lerData(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data = null;
        boolean dataValida = false;

        while (!dataValida) {
            System.out.println("Digite a data (YYYY-MM-DD): ");
            String dataEntrada = scanner.nextLine();

            try {
                data = LocalDate.parse(dataEntrada, formatter);
                dataValida = true; 
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data invalido. Tente novamente");
            }
        }

        return data;
    }
}