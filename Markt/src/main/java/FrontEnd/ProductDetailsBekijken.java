package FrontEnd;

import domain.Product;
import util.InvoerHelpers;

public class ProductDetailsBekijken {
    public void start(Product p) {

        while (true) {
            System.out.println("\n[" + p.getId() + "] " + p.getNaam());
            System.out.println("----------------------------------------------");
            System.out.println("Beschrijving: " + p.getBeschrijving());

            String s = InvoerHelpers.scanner.nextLine();
            try {
                switch (s) {
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
