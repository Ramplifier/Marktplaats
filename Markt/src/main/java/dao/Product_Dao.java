package dao;

import domain.Product;

import javax.persistence.EntityManager;

public class Product_Dao extends Dao<Product, Long> {
    public Product_Dao(EntityManager em) {
        super(em);
    }


}
