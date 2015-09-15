<%-- 
    Document   : index
    Created on : 15/09/2015, 18:06:04
    Author     : bruce
--%>

<%@page import="com.br.lp3.model.Livro"%>
<%@page import="com.br.lp3.dao.LivroDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de emprestimos</title>
    </head>
    <body>
        <h1>Sistema de emprestimos</h1>
        <fieldset>
            <legend>Cadastrar Livro</legend>
            <form name="frm_livro" action="CadastraLivro" method="POST">
                <p>Nome: <input type="text" name="nome_livro"/></p>
                <p><input type="submit" value="Enviar"/></p>
            </form>
        </fieldset>

        <fieldset>
            <legend>Livros cadastrados</legend>
            <form name="frm_livros_cadastrados" action="RemoveLivro" method="POST">
                <select name="livros">
                    <jsp:useBean class="com.br.lp3.dao.LivroDAO" id="livroDao"/>
                    <c:set var="livros" value="${livroDao.read()}"/>
                    <c:forEach var="livro"items="${livros}">
                        <option value="${livro.id}">${livro.nome}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Remover Livro"/>
            </form>
        </fieldset>

        <fieldset>
            <legend>Cadastrar Amigo</legend>
            <form name="frm_amigo" action="CadastraAmigo" method="POST">
                <p>Nome: <input type="text" name="nome_amigo"/></p>
                <p>Telefone: <input type="text" name="telefone"/></p>
                <p><input type="submit" value="Enviar"/></p>
            </form>
        </fieldset>

        <fieldset>
            <legend>Amigos cadastrados</legend>
            <form name="frm_amigos_cadastrados" action="RemoveAmigo" method="POST">
                <select name="amigos">
                    <jsp:useBean class="com.br.lp3.dao.AmigoDAO" id="amigoDao"/>
                    <c:set var="amigos" value="${amigoDao.read()}"/>
                    <c:forEach var="amigo" items="${amigos}">
                        <option value="${amigo.id}">${amigo.nome} - ${amigo.telefone}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Remover Amigo"/>
            </form>
        </fieldset>

        <fieldset>
            <legend>Novo emprestimo</legend>
            <form name="frm_novo_emprestimo" action="AdicionaEmprestimo" method="POST">
                <p>Emprestar: 
                    <select name="emprestar_livro">
                        <c:forEach var="livro"items="${livros}">
                            <option value="${livro.id}">${livro.nome}</option>
                        </c:forEach>
                    </select>
                    para: 
                    <select name="amigo_emprestimo">
                        <c:forEach var="amigo" items="${amigos}">
                            <option value="${amigo.id}">${amigo.nome} - ${amigo.telefone}</option>
                        </c:forEach>
                    </select>
                </p>
                <input type="submit" value="Emprestar"/>
            </form>
        </fieldset>

        <jsp:useBean class="com.br.lp3.dao.EmprestimoDAO" id="emprestimoDAO"/>
        <c:set var="emprestimos" value="${emprestimoDAO.read()}"/>

        <fieldset>
            <legend>Emprestimos realizados</legend>
            <table border='1'>
                <c:forEach items="${emprestimos}" var="emprestimo">
                    <tr>
                        <td>
                            ${emprestimo.idLivro.nome}
                        </td>
                        <td>
                            para-->
                        </td>
                        <td>
                            ${emprestimo.idAmigo.nome}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>   

        <fieldset>
            <legend>Remover Emprestimos</legend>
            <form name="frm_remove_emprestimo" action="RemoveEmprestimo" method="POST">
                <table border='1'>
                    <c:forEach items="${emprestimos}" var="emprestimo">
                        <tr>
                            <td>
                                <input type="radio" name="emprestimo" value="${emprestimo.id}"/>
                            </td>
                            <td>
                                ${emprestimo.idLivro.nome}
                            </td>
                            <td>
                                ${emprestimo.idAmigo.nome}
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="submit" value="Remover Emprestimo"/>
            </form>
        </fieldset>  
    </body>
</html>
