package FrontEnd;

import dao.Gebruiker_Dao;
import org.App;

import static util.InvoerHelpers.invoerveld;

public class Inloggen {
    Gebruiker_Dao dao = new Gebruiker_Dao(App.em);

    public void start() {
        while (true) {
            System.out.println("Account aanmaken");
            System.out.println("----------------------------------------------");
            String email = invoerveld("email");
            String wachtwoord = invoerveld("Wachtwoord");
            if (dao.getByEmail(email).getWachtwoord().equals(wachtwoord)) {
                Hoofdpagina.ingelogdeGebruiker = dao.getByEmail(email);
                return;
            }
            System.out.println("De combinatie klopt niet.");
        }

    }
}
