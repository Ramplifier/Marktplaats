package FrontEnd;

import dao.Gebruiker_Dao;
import domain.Adres;
import domain.BezorgOpties;
import domain.Gebruiker;

import static org.App.em;
import static util.InvoerHelpers.*;

public class GebruikerAanmaken {
    Gebruiker_Dao dao = new Gebruiker_Dao(em);

    public void start() {

        while (true) {
            System.out.println("Account aanmaken");
            System.out.println("----------------------------------------------");
            gebruikerAanmaken();
            return;
        }
    }

    private void gebruikerAanmaken() {
        Gebruiker g = new Gebruiker();
        g.setEmail(invoerveld("Email"));
        g.setWachtwoord(invoerveld("Wachtwoord"));
        g.setNaam(invoerveld("naam"));
        System.out.println(g.getEmail());
        if (invoerveldYN("Wil je een adres toevoegen?")) {
            g.setAdres(adresAanmaken());
        }
        System.out.println("Welke bezorgopties wil je aan je account toevoegen?");
        g.setBezorgOpties(bezorgOptiesAanmaken());

        if (invoerveldYN("Ga je akkoord met de voorwaarde")) {
            dao.save(g);
            System.out.println("De gebruiker is succesvol aangemaakt.");
        } else {
            System.out.println("Om de gebruiker aan te maken zullen de voorwaarden geaccepteerd moeten worden.");
        }
    }

    private Adres adresAanmaken() {
        Adres a = new Adres();
        a.setStraatnaam(invoerveld("Straatnaam"));
        a.setHuisnummer(invoerveldNum("Huisnummer"));
        a.setToevoeging(invoerveld("Toevoeging"));
        a.setPostcode(invoerveld("Postcode"));
        a.setWoonplaats(invoerveld("Woonplaats"));
        return a;
    }

    private BezorgOpties bezorgOptiesAanmaken() {
        BezorgOpties bo = new BezorgOpties();
        bo.setAfhalen(invoerveldYN("Afhalen bij de verkoper?"));
        bo.setMagazijn(invoerveldYN("Afhalen op het magazijn"));
        bo.setRembours(invoerveldYN("Versturen onder rembours"));
        bo.setVersturen(invoerveldYN("Versturen zonder rembours"));
        return bo;
    }


}
