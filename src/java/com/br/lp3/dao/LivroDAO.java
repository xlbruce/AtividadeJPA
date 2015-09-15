package com.br.lp3.dao;

import com.br.lp3.model.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author bruce
 */
public class LivroDAO implements DAO<Livro> {

    @Override
    public void insert(Livro e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColecoesPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Livro e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColecoesPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Livro e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColecoesPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Livro> read() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColecoesPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e From Livro e");
        List<Livro> livros = query.getResultList();
        em.close();
        return livros;
    }
    
}
