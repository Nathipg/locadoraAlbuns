<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Empréstimo</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Alterar Empréstimo</h1>

        <form method="post" action="${pageContext.request.contextPath}/TipoEmprestimoServlet">

            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="${requestScope.tipoEmprestimo.id}"/>

            <table>
                <tr>
                    <td class="alinharDireita">Dias</td>
                    <td>
                        <input name="diasDuracao" type="number" value="${requestScope.tipoEmprestimo.diasDuracao}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Valor</td>
                    <td>
                        <input name="valor" type="text" size="12" value="${requestScope.tipoEmprestimo.valor}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/tipoEmprestimos/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>