package org;

import FrontEnd.Hoofdpagina;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class App {

    //private final Logger log = LoggerFactory.getLogger(App.class);

    public static final EntityManager em = Persistence.createEntityManagerFactory("MySQL-Marktplaats").createEntityManager();


    public static void main(String[] args) {
        new Hoofdpagina().start();

    }
}