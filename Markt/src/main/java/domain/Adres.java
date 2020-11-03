package domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Adres extends Entiteit {

    @Column(nullable = false)
    private String straatnaam;

    @Column(nullable = false)
    private int huisnummer;

    private String toevoeging;

    @Column(nullable = false, length = 6)
    private String postcode;

    @Column(nullable = false)
    private String woonplaats;

    public Adres() {

    }
}
