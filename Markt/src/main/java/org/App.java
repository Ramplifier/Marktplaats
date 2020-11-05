package org;

import FrontEnd.Hoofdpagina;
import dao.Gebruiker_Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.EntitySubstitutes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class App {

    private final Logger log = LoggerFactory.getLogger(App.class);

    public static final EntityManager em = Persistence.createEntityManagerFactory("MySQL-Marktplaats").createEntityManager();


    public static void main(String[] args) {
        Gebruiker_Dao gebruiker_dao = new Gebruiker_Dao(em);
        gebruiker_dao.save(EntitySubstitutes.getGebruikerVolledig());
        new Hoofdpagina().start();

    }
}