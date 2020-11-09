package util;

import domain.Product;

public class OpmaakHelpers {
    public static String AdvertentieOpmaken(Product p) {
        String advertentie = "[" + p.getId() + "] " +
                p.getNaam() + ": " + p.getBeschrijving() + " - " + p.getPrijs();
        return advertentie;

    }
}
