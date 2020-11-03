package dao;

import domain.Gebruiker;

import javax.persistence.EntityManager;

public class Gebruiker_Dao extends Dao<Gebruiker, Long> {

    public Gebruiker_Dao(EntityManager em) {
        super(em);
    }

    public Gebruiker getByEmail(String email) {
        
    }

}
