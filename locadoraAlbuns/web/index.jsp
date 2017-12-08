<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locadora de Álbuns</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilo.css"/>
    </head>

    <body>

        <h1>Locadora de Álbuns</h1>

        <p>
            <a href="${pageContext.request.contextPath}/formularios/bandas/listagem.jsp">Bandas</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/formularios/generos/listagem.jsp">Gêneros</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/formularios/musicos/listagem.jsp">Músicos</a>
        </p>
        <!--
        <p>
            <a href="${pageContext.request.contextPath}/formularios/cidades/listagem.jsp">Musicos</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/formularios/estados/listagem.jsp">Estados</a>
        </p>
        -->

    </body>

</html>
