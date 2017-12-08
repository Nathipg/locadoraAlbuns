<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Músicos Cadastrados</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>
        
        <h1>Músicos Cadastrados</h1>

        <p><a href="${pageContext.request.contextPath}/formularios/musicos/novo.jsp">Novo Músico</a></p>

        <table class="tabelaListagem">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Data Nascimento</th>
                    <th>Bio</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>

                <jsp:useBean id="servicos" scope="page" class="locadoraAlbuns.servicos.MusicoServices"/>

                <c:forEach items="${servicos.todos}" var="musico">
                    <tr>
                        <td>${musico.id}</td>
                        <td>${musico.nome}</td>
                        <td>${musico.dataNascimento}</td>
                        <td>${musico.bio}</td>
                        <td><a href="${pageContext.request.contextPath}/MusicoServlet?acao=prepAlteracao&id=${musico.id}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/MusicoServlet?acao=prepExclusao&id=${musico.id}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/formularios/musicos/novo.jsp">Novo Músico</a></p>
        
        <p><a href="${pageContext.request.contextPath}/index.jsp">Tela Principal</a></p>

    </body>

</html>
