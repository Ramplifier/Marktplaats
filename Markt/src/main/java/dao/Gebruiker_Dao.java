package dao;

import domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Gebruiker_Dao extends Dao<Gebruiker, Long> {

    public Gebruiker_Dao(EntityManager em) {
        super(em);
    }

    public Gebruiker getByEmail(String email) {

        TypedQuery<Gebruiker> query = em.createQuery("select g from Gebruiker g where g.email like :firstarg", Gebruiker.class);
        query.setParameter("firstarg", email);
        return query.getSingleResult();
    }
}
