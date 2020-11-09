package util;

import domain.Adres;
import domain.BezorgOpties;
import domain.Gebruiker;
import domain.Product;

import java.math.BigDecimal;

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
        BezorgOpties b = new BezorgOpties();
        b.setVersturen(true);
        b.setAfhalen(true);
        g.setBezorgOpties(b);
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
        BezorgOpties b = new BezorgOpties();
        b.setVersturen(true);
        b.setAfhalen(true);
        g.setBezorgOpties(b);
        return g;
    }

    public static Product getProductVolledig(Gebruiker g, String n) {
        Product p = new Product();
        p.setNaam(n);
        p.setBeschrijving("Een nette en duidelijke beschrijving van het product");
        p.setEigenaarId(g);
        p.setBezorgOpties(new BezorgOpties());
        p.setPrijs(new BigDecimal("50.0"));
        return p;
    }
}
