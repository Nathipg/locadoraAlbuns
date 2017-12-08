<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipos de Empréstimos</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>
        
        <h1>Tipos de Empréstimos</h1>

        <p><a href="${pageContext.request.contextPath}/formularios/tipoEmprestimos/novo.jsp">Novo Usuário</a></p>

        <table class="tabelaListagem">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Dias Duração</th>
                    <th>Valor</th>
                </tr>
            </thead>
            <tbody>

                <jsp:useBean id="servicos" scope="page" class="locadoraAlbuns.servicos.TipoEmprestimoServices"/>

                <c:forEach items="${servicos.todos}" var="tipoEmprestimo">
                    <tr>
                        <td>${tipoEmprestimo.id}</td>
                        <td>${tipoEmprestimo.diasDuracao}</td>
                        <td>${tipoEmprestimo.valor}</td>
                        <td><a href="${pageContext.request.contextPath}/TipoEmprestimoServlet?acao=prepAlteracao&id=${tipoEmprestimo.id}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/TipoEmprestimoServlet?acao=prepExclusao&id=${tipoEmprestimo.id}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/formularios/tipoEmprestimos/novo.jsp">Novo Usuário</a></p>
        
        <p><a href="${pageContext.request.contextPath}/index.jsp">Tela Principal</a></p>

    </body>

</html>