package domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@Data
@MappedSuperclass
public abstract class Artikel extends Entiteit {

    private String naam;

    private String Beschrijving;

    private String categorie;

    private BigDecimal prijs;

    @ManyToOne(cascade = CascadeType.ALL)
    private Gebruiker eigenaarId;

    public Artikel() {
    }
}
