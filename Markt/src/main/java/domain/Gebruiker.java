package domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Gebruiker extends Entiteit {

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String wachtwoord;

    @Column(nullable = false)
    private String naam;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Adres adres;

    @Embedded
    private BezorgOpties bezorgOpties;

    private boolean isAkkoord;


    private boolean isActief;

    public Gebruiker() {
    }

    @Override
    public String toString() {

        return "Gebruiker{" +
                "email='" + email + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                ", naam='" + naam + '\'' +
                ", adres='" + (this.adres == null ? "ja" : "nee") + '\'' +
                ", isActief=" + isActief +
                '}';
    }
}
