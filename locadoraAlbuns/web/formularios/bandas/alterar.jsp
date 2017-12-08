<%-- 
    Document   : alterar
    Created on : 08/12/2017, 00:31:29
    Author     : CaueSJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Banda</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Alterar Banda</h1>

        <form method="post" action="${pageContext.request.contextPath}/processaBanda">

            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="${requestScope.banda.id}"/>

            <table>
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>
                        <input name="nome" type="text" size="20" value="${requestScope.banda.nome}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Data de Formação:</td>
                    <td>
                        <input name="dataFormacao" type="date" value="${requestScope.banda.dataFormacao}">
                    </td>
                </tr>
                <tr>
                    <td class="alinhaDireita">Descrição:</td>
                    <td>
                        <textarea name="descricao" rows="5">${requestScope.banda.descricao}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/bandas/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Alterar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
