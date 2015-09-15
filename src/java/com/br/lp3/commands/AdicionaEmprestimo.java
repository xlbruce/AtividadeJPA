package com.br.lp3.commands;

import com.br.lp3.dao.AmigoDAO;
import com.br.lp3.dao.DAO;
import com.br.lp3.dao.EmprestimoDAO;
import com.br.lp3.dao.LivroDAO;
import com.br.lp3.model.Amigo;
import com.br.lp3.model.Emprestimo;
import com.br.lp3.model.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bruce
 */
public class AdicionaEmprestimo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {  
            AmigoDAO amigoDao = new AmigoDAO();
            EmprestimoDAO emprestimoDao = new EmprestimoDAO();
            LivroDAO livroDao = new LivroDAO();
            
            int idLivro = 0, idAmigo = 0;
            try {
                idLivro = Integer.parseInt(request.getParameter("emprestar_livro"));
                idAmigo = Integer.parseInt(request.getParameter("amigo_emprestimo"));
            } catch (NumberFormatException ex) {
                out.print("Erro ao converter a string");
                out.print(ex.getMessage());
            }
            
            Emprestimo emprestimo = new Emprestimo();
            Amigo amigo = amigoDao.readById(idAmigo);
            Livro livro = livroDao.readById(idLivro);
            emprestimo.setIdAmigo(amigo);
            emprestimo.setIdLivro(livro);
            emprestimoDao.insert(emprestimo);
            
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
