package FrontEnd;

import domain.Gebruiker;

import java.util.Scanner;

public class Hoofdpagina {

    public static Gebruiker ingelogdeGebruiker = null;

    public void start() {

        while (true) {
            if (ingelogdeGebruiker == null) {
                bezoekerIsIngelogd();

            } else {
                gebruikerIsIngelogd();
            }
        }
    }


    private void gebruikerIsIngelogd() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("Welkom " + ingelogdeGebruiker.getNaam());
            System.out.println("Wat wilt u doen?");
            System.out.println("----------------------------------------------");
            System.out.println("[1] Artikel aanbieden");
            System.out.println("[2] Lijst met aangeboden artikelen bekijken");
            System.out.println("[3] Uitloggen");
            System.out.println("[x] Afsluiten");
            String s = scanner.nextLine();
            try {
                switch (s) {
                    case "1":
                        System.out.println("bied een product aan.");
                        return;
                    case "2":
                        System.out.println("bekijk alle producten.");
                        return;
                    case "3":
                        ingelogdeGebruiker = null;
                        break;
                    case "x":
                        System.out.println("Tot ziens.");
                        return;
                    default:
                        System.out.println("Ongeldige keuze; probeer opnieuw.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Dit is ongeldige invoer. Probeer het opnieuw.");
            } catch (RuntimeException t) {
                System.out.println("Er ging iets mis... Probeer het opnieuw. ");
                System.out.println("Foutmelding: " + t.getMessage());
            } catch (Exception e) {
                System.out.println("Er ging iets vreselijk mis... ");
                System.out.println("Foutmelding: " + e.getMessage());
                System.out.println("Tot ziens.");
            }
        }
    }

    public void bezoekerIsIngelogd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("Welkom bij tweedeliefde.nl");
        System.out.println("Wat wilt u doen?");
        System.out.println("----------------------------------------------");
        System.out.println("[1] Gebruiker aanmaken");
        System.out.println("[2] Inloggen");
        System.out.println("[x] Afsluiten");

        String s = scanner.nextLine();
        try {
            switch (s) {
                case "1":
                    new GebruikerAanmaken().start();
                    break;
                case "2":
                    new Inloggen().start();
                    break;
                case "x":
                    System.out.println("Tot ziens.");
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Dit is ongeldige invoer. Probeer het opnieuw.");
        } catch (RuntimeException t) {
            System.out.println("Er ging iets mis... Probeer het opnieuw. ");
            System.out.println("Foutmelding: " + t.getMessage());
        } catch (Exception e) {
            System.out.println("Er ging iets vreselijk mis... ");
            System.out.println("Foutmelding: " + e.getMessage());
            System.out.println("Tot ziens.");
        }


    }
}