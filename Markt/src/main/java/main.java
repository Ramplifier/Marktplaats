import dao.Gebruiker_Dao;
import domain.Adres;
import domain.Gebruiker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.EntitySubstitutes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;


public class main {

    private final Logger log = LoggerFactory.getLogger(main.class);

    private EntityManager em;
    private Scanner input;

    private Gebruiker_Dao gebruikerDao;


    public static void main(String[] args) {

        main app = new main();
        app.startUp();
        Gebruiker g = EntitySubstitutes.getGebruikerVolledig("Piet@paat.nl");
        app.gebruikerDao.save(g);
        app.pagina_Hoofdmenu();
        System.out.println(app.gebruikerDao.get((long) app.input.nextInt()).toString());
        System.out.println("Einde");

    }

    private void startUp() {
        em = Persistence.createEntityManagerFactory("MySQL-Marktplaats").createEntityManager();
        input = new Scanner(System.in);

        gebruikerDao = new Gebruiker_Dao(em);

        System.out.println("\n\nWelkom to tweedeliefde.nl\n");

    }

    public void pagina_Hoofdmenu() {
        String[] opties = {
                "1.Account aanmaken",
                "2.Inloggen",
                "3.Lees de voorwaarden",
                "4.Afbreken"};
        System.out.println("Hoofdpagina");
        printOpties(opties);
        switch (chooseOption(opties.length)) {
            case 1:
                pagina_AccountAanmaken();
                break;
            case 2:
                System.out.println("gekozen -> inlogpagina");
                break;
            case 3:
                System.out.println("gekozen -> Lees de voorwaarden");
                break;
            default:
                return;
        }

    }

    public void pagina_AccountAanmaken() {
        System.out.println("\nAccount aanmaken");
        Gebruiker g = new Gebruiker();
        System.out.print("Email: ");
        g.setEmail(input.next());
        System.out.print("wachtwoord: ");
        g.setWachtwoord(input.next());
        System.out.print("naam: ");
        g.setNaam(input.next());
        System.out.println("Wil je een adres toevoegen?[y/n]");
        if (input.next().toLowerCase().contains("y")) {
            Adres a = new Adres();
            System.out.print("straatnaam: ");
            a.setStraatnaam(input.next());
            System.out.print("huisnummer: ");
            a.setHuisnummer(verifieerInvoerNummer());
            System.out.print("toevoeging: ");
            a.setToevoeging(input.next());
            System.out.print("postcode: ");
            a.setPostcode(input.next().replaceAll("\\s", ""));
            System.out.print("woonplaats: ");
            a.setWoonplaats(input.next());
            g.setAdres(a);
        }
        System.out.println("Ga je akkoord met voorwaarden?[y/n]");
        if (input.next().toLowerCase().contains("y")) {
            gebruikerDao.save(g);
            System.out.println("Je account is aangemaakt.");
        } else {
            System.out.println("Je moet de voorwaarden accepteren als je een account wil aanmaken.");
        }


    }

    public void pagina_Inloggen() {
        System.out.println("\nInloggen");
        System.out.print("email: ");
        String email = input.next();
        System.out.print("email: ");
        String wachtwoord = input.next();



    }


    public void printOpties(String[] opties) {
        for (String optie : opties) {
            System.out.println(optie);
        }
    }

    public int chooseOption(int length) {
        int choice = -1;
        while (choice == -1 || choice > length) {

            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("De invoer is niet geldig");
                continue;
            }

        }
        return choice;
    }

    private int verifieerInvoerNummer() {
        int i = -1;
        do {
            try {
                i = Integer.parseInt(input.next());
            } catch (Exception e) {
                System.out.println("De invoer is niet geldig");
                continue;
            }
        }
        while (i == -1);
        return i;
    }

}
