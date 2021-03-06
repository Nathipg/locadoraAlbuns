<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Músicos</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Novo Músicos</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/MusicoServlet">

            <input name="acao" type="hidden" value="criar"/>

            <table>
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>
                        <input name="nome" type="text" size="45"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Data Nascimento:</td>
                    <td>
                        <input name="dataNascimento" type="text" size="10"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Bio: </td>
                    <td>
                        <textarea name="bio" rows="4"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/musicos/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
