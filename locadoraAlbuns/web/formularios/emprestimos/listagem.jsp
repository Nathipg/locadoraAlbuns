<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empréstimos Cadastrados</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>
        
        <h1>Empréstimos Cadastrados</h1>

        <p><a href="${pageContext.request.contextPath}/formularios/formacoes/novo.jsp">Novo Empréstimo</a></p>

        <table class="tabelaListagem">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Banda</th>
                    <th>Músico</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>

                <jsp:useBean id="servicos" scope="page" class="locadoraAlbuns.servicos.EmprestimoServices"/>

                <c:forEach items="${servicos.todos}" var="emprestimo">
                    <tr>
                        <td>${emprestimo.id}</td>
                        <td>${emprestimo.banda.nome}</td>
                        <td>${emprestimo.musico.nome}</td>
                        <td><a href="${pageContext.request.contextPath}/EmprestimoServlet?acao=prepAlteracao&id=${emprestimo.id}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/EmprestimoServlet?acao=prepExclusao&id=${emprestimo.id}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/formularios/formacoes/novo.jsp">Novo Empréstimo</a></p>
        
        <p><a href="${pageContext.request.contextPath}/index.jsp">Tela Principal</a></p>

    </body>

</html>