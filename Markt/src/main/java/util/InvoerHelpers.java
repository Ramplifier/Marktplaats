package util;

import java.util.Scanner;

public class InvoerHelpers {
    public static Scanner scanner = new Scanner(System.in);

    public static String invoerveld(String veld) {
        System.out.print(veld + ": ");
        return scanner.next();
    }

    public static String invoerveldNull(String veld) {
        System.out.print(veld + ": ");
        String i = scanner.next();
        if (scanner.hasNext()) {
            return i;
        } else
            return null;

    }

    public static int invoerveldNum(String veld) {
        System.out.print(veld + ": ");
        int huisnum;
        try {
            huisnum = scanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Dit is geen geldig huisnummer");
            return invoerveldNum(veld);
        }
        return huisnum;
    }

    public static Boolean invoerveldYN(String vraag) {
        System.out.print(vraag + " [y/n] ");
        return scanner.next().toLowerCase().equals("y");
    }
}
