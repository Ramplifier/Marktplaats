package util;

import java.math.BigDecimal;
import java.util.Scanner;

public class InvoerHelpers {
    public static Scanner scanner = new Scanner(System.in);

    public static String invoerveld(String veld) {
        System.out.print(veld + ": ");
        return scanner.nextLine();
    }

    public static int invoerveldInt(String veld) {
        System.out.print(veld + ": ");
        int num;
        try {
            num = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Dit is geen geldig huisnummer");
            return invoerveldInt(veld);
        }
        return num;
    }

    public static Long invoerveldLong(String veld) {
        System.out.print(veld + ": ");
        Long num;
        try {
            num = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Dit is geen geldig huisnummer");
            return invoerveldLong(veld);
        }
        return num;
    }

    public static BigDecimal invoerveldBigDecimal(String veld) {
        System.out.println(veld + ": (*.00) ");
        BigDecimal num;
        try {
            num = new BigDecimal(String.valueOf(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Dit is geen geldige prijs.");
            return invoerveldBigDecimal(veld);
        }
        return num;
    }

    public static Boolean invoerveldYN(String vraag) {
        System.out.print(vraag + " [y/n] ");
        return scanner.nextLine().toLowerCase().equals("y");
    }
}
