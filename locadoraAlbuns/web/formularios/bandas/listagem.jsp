<%-- 
    Document   : listagem
    Created on : 07/12/2017, 21:33:48
    Author     : CaueSJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bandas Cadastradas</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilo.css"/>
    </head>

    <body>
        
        <h1>Bandas Cadastradas</h1>

        <p><a href="${pageContext.request.contextPath}/formularios/bandas/novo.jsp">Nova Banda</a></p>

        
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Data Formação</th>
                    <th>Descrição</th>
                </tr>
            </thead>
            

                <jsp:useBean id="servicos" scope="page" class="locadoraAlbuns.servicos.BandaServices"/>

                <c:forEach items="${servicos.todos}" var="banda">
                    <tr>
                        <td>${banda.id}</td>
                        <td>${banda.nome}</td>
                        <td>${banda.dataFormacao}</td>
                        <td><a href="${pageContext.request.contextPath}/processaBanda?acao=prepAlteracao&id=${banda.id}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/processaBanda?acao=prepExclusao&id=${banda.id}">Excluir</a></td>
                    </tr>
                </c:forEach>
            
        

        <p><a href="${pageContext.request.contextPath}/formularios/bandas/novo.jsp">Nova Cidade</a></p>
        
        <p><a href="${pageContext.request.contextPath}/index.jsp">Tela Principal</a></p>

    </body>

</html>
