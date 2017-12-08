<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Músico</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Alterar Músico</h1>

        <form method="post" action="${pageContext.request.contextPath}/MusicoServlet">

            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="${requestScope.musico.id}"/>

            <table>
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>
                        <input name="nome" type="text" size="20"
                               value="${requestScope.musico.nome}"/>
                    </td>                    
                </tr>
                <tr>
                    <td class="alinharDireita">Data Nascimento:</td>
                    <td>
                        <input name="dataNascimento" type="text" size="20"
                               value="${requestScope.musico.dataNascimento}"/>
                    </td>                    
                </tr>
                <tr>
                    <td class="alinharDireita">Bio</td>
                    <td>
                        <input name="bio" type="text" size="20"
                               value="${requestScope.musico.bio}"/>
                    </td>                    
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/musicos/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Alterar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
