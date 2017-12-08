<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Empréstimo</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Cadastrar Empréstimo</h1>

        <form method="post" action="${pageContext.request.contextPath}/TipoEmprestimoServlet">

            <input name="acao" type="hidden" value="criar"/>

            <table>
                <tr>
                    <td class="alinharDireita">Dias</td>
                    <td>
                        <input name="diasDuracao" type="number"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Valor</td>
                    <td>
                        <input name="valor" type="text" size="12"/>
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