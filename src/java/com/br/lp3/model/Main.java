package com.br.lp3.model;

import com.br.lp3.dao.LivroDAO;

/**
 *
 * @author bruce
 */
public class Main {
    
    public static void main(String[] args) {
        LivroDAO dao = new LivroDAO();
        Livro l = new Livro();
        l.setNome("livro1");
        dao.insert(l);
    }
}
