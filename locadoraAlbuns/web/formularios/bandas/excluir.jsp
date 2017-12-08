<%-- 
    Document   : excluir
    Created on : 08/12/2017, 00:11:25
    Author     : CaueSJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Banda</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilo.css"/>
    </head>

    <body>

        <h1>Excluir Banda</h1>

        <form method="post" action="${pageContext.request.contextPath}/processaBanda">

            <input name="acao" type="hidden" value="excluir"/>
            <input name="id" type="hidden" value="${requestScope.banda.id}"/>

            <table>
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>${requestScope.banda.nome}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Data Formação:</td>
                    <td>${requestScope.banda.dataFormacao}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Descrição:</td>
                    <td>${requestScope.banda.descricao}</td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/cidades/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Excluir"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
