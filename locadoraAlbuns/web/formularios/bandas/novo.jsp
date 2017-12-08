<%-- 
    Document   : novo
    Created on : 07/12/2017, 21:59:50
    Author     : CaueSJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Banda</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>
    
    <body>
        <h1>Cadastrar Banda</h1>
        
        <form method="post" action="${pageContext.request.contextPath}/processaBanda">

            <input name="acao" type="hidden" value="criar"/>

            <table>
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>
                        <input name="nome" type="text" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Data Formação: </td>
                    <td>
                        <input name="dataFormacao" type="text" size="10">
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Descrição: </td>
                    <td>
                        <textarea name="descricao" rows="4"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/bandas/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"/>
                    </td>
                </tr>
            </table>

        </form>
        
    </body>
    
</html>
