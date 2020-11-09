package FrontEnd;

import dao.Gebruiker_Dao;
import dao.Product_Dao;
import domain.Gebruiker;
import domain.Product;
import org.App;
import util.EntitySubstitutes;

import java.util.Scanner;

public class Hoofdpagina {
    Gebruiker_Dao gebruiker_dao = new Gebruiker_Dao(App.em);
    Product_Dao product_dao = new Product_Dao(App.em);
    public static Gebruiker ingelogdeGebruiker;
    boolean sessie = true;

    public void start() {
        gebruiker_dao.save(EntitySubstitutes.getGebruikerVolledig());
        Gebruiker g = EntitySubstitutes.getGebruikerVolledig("Hallo@Hallo.nl");
        gebruiker_dao.save(g);
        ingelogdeGebruiker = gebruiker_dao.getByEmail("sjwarkel@gmail.com");
        Product p = EntitySubstitutes.getProductVolledig(ingelogdeGebruiker, "Fiets");
        Product p2 = EntitySubstitutes.getProductVolledig(g, "DS");
        product_dao.save(p);
        product_dao.save(p2);

        while (sessie) {
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
            System.out.println("[3] Eigen producten bekijken");
            System.out.println("[4] Uitloggen");
            System.out.println("[x] Afsluiten");
            String s = scanner.nextLine();
            try {
                switch (s) {
                    case "1":
                        new ProductAanbieden().start();
                        return;
                    case "2":
                        new ProductenlijstBekijken().start();
                        return;
                    case "3":
                        new EigenProductenBekijken().start();
                        return;
                    case "4":
                        ingelogdeGebruiker = null;
                        return;
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
                    sessie = false;
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