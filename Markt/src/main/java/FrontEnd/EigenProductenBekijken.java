package FrontEnd;

import dao.Product_Dao;
import org.App;
import util.InvoerHelpers;

import static util.OpmaakHelpers.AdvertentieOpmaken;

public class EigenProductenBekijken {
    public void start() {
        Product_Dao product_dao = new Product_Dao(App.em);

        while (true) {
            System.out.println("Producten die jij aanbiedt");
            System.out.println("----------------------------------------------");
            product_dao.findByEigenaarId(Hoofdpagina.ingelogdeGebruiker.getId()).forEach(p -> System.out.println(AdvertentieOpmaken(p)));
            System.out.println("----------------------------------------------");
            String s = InvoerHelpers.scanner.nextLine();
            try {
                switch (s) {
                    case "1":
                        System.out.println("Details van een product bekijken");
                        return;
                    case "x":
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
}
