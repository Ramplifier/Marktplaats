package domain;

import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@MappedSuperclass
public abstract class Artikel extends Entiteit {

    private String naam;

    private String Beschrijving;

    private String categorie;

    private BigDecimal prijs;

    public Artikel() {
    }
}
