package com.br.lp3.dao;

import java.util.List;

/**
 *
 * @author bruce
 */
public interface DAO<E> {
    
    public void insert(E e);
    public void update(E e);
    public void remove(E e);
    public List<E> read();
}
