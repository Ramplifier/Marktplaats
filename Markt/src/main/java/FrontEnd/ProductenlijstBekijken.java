package FrontEnd;

import dao.Product_Dao;
import org.App;
import util.InvoerHelpers;

import static util.OpmaakHelpers.AdvertentieOpmaken;

public class ProductenlijstBekijken {
    Product_Dao product_dao = new Product_Dao(App.em);

    public void start() {

        while (true) {
            System.out.println("Lijst met aangeboden producten");
            System.out.println("----------------------------------------------");
            product_dao.findAll().forEach(p -> System.out.println(AdvertentieOpmaken(p)));
            System.out.println("----------------------------------------------");
            System.out.println("[1] Details van een product bekijken");
            System.out.println("[x] Afsluiten");
            String s = InvoerHelpers.scanner.nextLine();
            try {
                switch (s) {
                    case "1":
                        System.out.println("Welk product wil je details van zien?");
                        new ProductDetailsBekijken().start(product_dao.get(InvoerHelpers.invoerveldLong("Id")));
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
}
