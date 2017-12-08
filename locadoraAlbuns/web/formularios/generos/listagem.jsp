<%-- 
    Document   : listagem
    Author     : nathipg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gêneros Cadastrados</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>
        
        <h1>Gêneros Cadastrados</h1>

        <p><a href="${pageContext.request.contextPath}/formularios/generos/novo.jsp">Novo Gênero</a></p>

        <table class="tabelaListagem">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>

                <jsp:useBean id="servicos" scope="page" class="locadoraAlbuns.servicos.GeneroServices"/>

                <c:forEach items="${servicos.todos}" var="genero">
                    <tr>
                        <td>${genero.id}</td>
                        <td>${genero.nome}</td>
                        <td><a href="${pageContext.request.contextPath}/GeneroServlet?acao=prepAlteracao&id=${genero.id}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/GeneroServlet?acao=prepExclusao&id=${genero.id}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/formularios/generos/novo.jsp">Novo Gênero</a></p>
        
        <p><a href="${pageContext.request.contextPath}/index.jsp">Tela Principal</a></p>

    </body>

</html>
