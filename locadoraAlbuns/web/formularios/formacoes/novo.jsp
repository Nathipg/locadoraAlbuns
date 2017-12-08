<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Formação</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Novo Formação</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/FormacaoServlet">

            <input name="acao" type="hidden" value="criar"/>

            <table>
                <tr>
                    <td class="alinharDireita">Data Início </td>
                    <td>
                        <input name="inicio" type="date" size="10">
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Data Fim </td>
                    <td>
                        <input name="fim" type="date" size="10">
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Banda</td>
                    <td>
                        <select>
                            <jsp:useBean id="bandas" scope="page" class="locadoraAlbuns.servicos.BandaServices"/>
                            
                            <c:forEach items="${bandas.todos}" var="banda">
                                <option value="${banda.id}">${banda.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Músico</td>
                    <td>
                        <input name="fim" type="date" size="10">
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/formacoes/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
