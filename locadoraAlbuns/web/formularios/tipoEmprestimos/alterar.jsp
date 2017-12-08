<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Usuário</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Alterar Usuário</h1>

        <form method="post" action="${pageContext.request.contextPath}/processaUsuario">

            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="${requestScope.usuario.id}"/>

            <table class="tabelaListagem">
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>
                        <input name="nome" type="text" size="20" value="${requestScope.usuario.nome}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">CPF:</td>
                    <td>
                        <input name="cpf" type="text" value="${requestScope.usuario.cpf}">
                    </td>
                </tr>
                <tr>
                    <td class="alinhaDireita">Email:</td>
                    <td>
                        <input name="descricao" type="text" value="${requestScope.usuario.email}">
                    </td>
                </tr>
                <tr>
                    <td class="alinhaDireita">Telefone Fixo:</td>
                    <td>
                        <input name="telefoneFixo" type="text" value="${requestScope.usuario.telefoneFixo}">
                    </td>
                </tr>
                <tr>
                    <td class="alinhaDireita">Telefone Celular:</td>
                    <td>
                        <input name="telefoneCelular" type="text" value="${requestScope.usuario.telefoneCelular}">
                    </td>
                </tr>
                <tr>
                    <td class="alinhaDireita">Endereço:</td>
                    <td>
                        <input name="endereco" type="text" value="${requestScope.usuario.endereco}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/usuarios/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Alterar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>