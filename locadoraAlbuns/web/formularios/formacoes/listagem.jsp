<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formações Cadastrados</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>
        
        <h1>Formações Cadastrados</h1>

        <p><a href="${pageContext.request.contextPath}/formularios/formacoes/novo.jsp">Nova Formação</a></p>

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

                <jsp:useBean id="servicos" scope="page" class="locadoraAlbuns.servicos.FormacaoServices"/>

                <c:forEach items="${servicos.todos}" var="formacao">
                    <tr>
                        <td>${formacao.id}</td>
                        <td>${formacao.banda.nome}</td>
                        <td>${formacao.musico.nome}</td>
                        <td><a href="${pageContext.request.contextPath}/FormacaoServlet?acao=prepAlteracao&id=${formacao.id}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/FormacaoServlet?acao=prepExclusao&id=${formacao.id}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/formularios/formacoes/novo.jsp">Nova Formação</a></p>
        
        <p><a href="${pageContext.request.contextPath}/index.jsp">Tela Principal</a></p>

    </body>

</html>
