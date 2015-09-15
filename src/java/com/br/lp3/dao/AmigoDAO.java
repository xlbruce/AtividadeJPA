package com.br.lp3.dao;

import com.br.lp3.model.Amigo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author bruce
 */
public class AmigoDAO implements DAO<Amigo> {

    @Override
    public void insert(Amigo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColecoesPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Amigo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColecoesPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Amigo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColecoesPU");
        EntityManager em = emf.createEntityManager();
        Amigo amigo = em.find(Amigo.class, e.getId());
        em.getTransaction().begin();
        em.remove(amigo);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Amigo> read() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColecoesPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e From Amigo e");
        List<Amigo> amigos = query.getResultList();
        em.close();
        return amigos;
    }
    public Amigo readById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColecoesPU");
        EntityManager em = emf.createEntityManager();
        Amigo amigo = em.find(Amigo.class, id);        
        return amigo;
    }
    
}
