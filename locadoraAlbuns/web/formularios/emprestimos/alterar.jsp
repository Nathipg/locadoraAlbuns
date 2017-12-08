<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Empréstimo</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Alterar Empréstimo</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/EmprestimoServlet">

            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="${requestScope.emprestimo.id}"/>

            <table class="tabelaListagem">
                <tr>
                    <td class="alinharDireita">Data Início:</td>
                    <td>
                        <input name="inicio" type="text" size="20"
                               value="${requestScope.emprestimo.inicio}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Data Fim:</td>
                    <td>
                        <input name="fim" type="text" size="20"
                               value="${requestScope.emprestimo.fim}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Usuário:</td>
                    <td>
                        <select name="idUsuario">
                            <jsp:useBean id="usuarios" scope="page" class="locadoraAlbuns.servicos.UsuarioServices"/>
                            
                            <c:forEach items="${usuarios.todos}" var="usuario">
                                <option value="${usuario.id}" ${usuario.id == requestScope.usuario.id ? "selected" : ""}>${usuario.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Álbum:</td>
                    <td>
                        <select name="idAlbum">
                            <jsp:useBean id="albuns" scope="page" class="locadoraAlbuns.servicos.AlbumServices"/>
                            
                            <c:forEach items="${albuns.todos}" var="album">
                                <option value="${album.id}" ${album.id == requestScope.album.id ? "selected" : ""}>${album.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/emprestimos/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Alterar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
