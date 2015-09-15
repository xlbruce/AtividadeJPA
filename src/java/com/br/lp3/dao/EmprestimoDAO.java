package com.br.lp3.dao;

import com.br.lp3.model.Emprestimo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author bruce
 */
public class EmprestimoDAO implements DAO<Emprestimo> {
    
    @Override
    public void insert(Emprestimo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColecoesPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Emprestimo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColecoesPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Emprestimo e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColecoesPU");
        EntityManager em = emf.createEntityManager();
        Emprestimo emprestimo = em.find(Emprestimo.class, e.getId());
        em.getTransaction().begin();
        em.remove(emprestimo);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Emprestimo> read() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColecoesPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e From Emprestimo e");
        List<Emprestimo> emprestimos = query.getResultList();
        em.close();
        return emprestimos;
    }
    
}
