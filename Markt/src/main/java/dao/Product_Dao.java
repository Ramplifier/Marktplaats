package dao;

import domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Product_Dao extends Dao<Product, Long> {
    public Product_Dao(EntityManager em) {
        super(em);
    }

    public List<Product> findByEigenaarId(Long id) {
        TypedQuery<Product> query = em.createQuery("Select p from Product p where concat( p.eigenaarId, '' ) Like :firstarg", Product.class);
        query.setParameter("firstarg", id.toString());
        return query.getResultList();
    }
}
