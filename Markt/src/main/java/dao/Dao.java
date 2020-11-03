package dao;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

public abstract class Dao<T, I> {
    protected final EntityManager em;

    protected Dao(EntityManager em) {
        this.em = em;
    }

    public T get(I id) {
        return em.find(T(), id);
    }

    public void save(T e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    private Class<T> T() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void remove(T e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }


}
