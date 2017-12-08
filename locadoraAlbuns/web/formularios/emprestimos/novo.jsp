<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Empréstimo</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Novo Empréstimo</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/EmprestimoServlet">

            <input name="acao" type="hidden" value="criar"/>

            <table>
                <tr>
                    <td class="alinharDireita">Data Início:</td>
                    <td>
                        <input name="inicio" type="text" size="10">
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Data Fim:</td>
                    <td>
                        <input name="fim" type="text" size="10">
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Usuário</td>
                    <td>
                        <select>
                            <jsp:useBean id="usuarios" scope="page" class="locadoraAlbuns.servicos.UsuarioServices"/>
                            
                            <c:forEach items="${usuarios.todos}" var="usuario">
                                <option value="${usuario.id}">${usuario.nome}</option>
                            </c:forEach>
                        </select>
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
                        <select>
                            <jsp:useBean id="musicos" scope="page" class="locadoraAlbuns.servicos.MusicoServices"/>
                            
                            <c:forEach items="${musicos.todos}" var="musico">
                                <option value="${musico.id}">${musico.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Álbum</td>
                    <td>
                        <select>
                            <jsp:useBean id="albuns" scope="page" class="locadoraAlbuns.servicos.AlbumServices"/>
                            
                            <c:forEach items="${albuns.todos}" var="album">
                                <option value="${album.id}">${album.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Tipo Empréstimo</td>
                    <td>
                        <select>
                            <jsp:useBean id="tipoEmprestimos" scope="page" class="locadoraAlbuns.servicos.TipoEmprestimoServices"/>
                            
                            <c:forEach items="${tipoEmprestimos.todos}" var="emprestimo">
                                <option value="${emprestimo.id}">${emprestimo.valor}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/emprestimos/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
