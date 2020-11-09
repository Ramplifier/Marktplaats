package dao;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class Dao<T, I> {
    protected final EntityManager em;

    protected Dao(EntityManager em) {
        this.em = em;
    }

    public T get(I id) {
        return em.find(T(), id);
    }

    public void save(T e) throws NullPointerException {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public List<T> findAll() {
        return em.createQuery("SELECT t from " + typeSimple() + " t ", T()).getResultList();
    }

    private String typeSimple() {
        return T().getSimpleName();
    }

    @SuppressWarnings("unchecked")
    private Class<T> T() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


}
