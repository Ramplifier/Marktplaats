package util;

import domain.Adres;
import domain.BezorgOpties;
import domain.Gebruiker;

public class EntitySubstitutes {
    public static Gebruiker getGebruikerVolledig() {
        Gebruiker g = new Gebruiker();
        g.setEmail("sjwarkel@gmail.com");
        g.setWachtwoord("PizzaPastaSauze");
        g.setNaam("Stijn van Arkel");
        Adres adres = new Adres();
        adres.setStraatnaam("Albardastraat");
        adres.setHuisnummer(56);
        adres.setPostcode("7331LH");
        adres.setWoonplaats("Apeldoorn");
        g.setAdres(adres);
        g.setActief(true);
        g.setAkkoord(true);
        g.setBezorgOpties(new BezorgOpties());
        return g;
    }

    public static Gebruiker getGebruikerVolledig(String email) {
        Gebruiker g = new Gebruiker();
        g.setEmail(email);
        g.setWachtwoord("PizzaPastaSauze");
        g.setNaam("Stijn van Arkel");
        Adres adres = new Adres();
        adres.setStraatnaam("Albardastraat");
        adres.setHuisnummer(56);
        adres.setPostcode("7331LH");
        adres.setWoonplaats("Apeldoorn");
        g.setAdres(adres);
        g.setActief(true);
        g.setAkkoord(true);
        return g;
    }
}
