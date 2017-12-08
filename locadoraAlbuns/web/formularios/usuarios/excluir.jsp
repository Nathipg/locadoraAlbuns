<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Usuário</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Excluir Usuário</h1>

        <form method="post" action="${pageContext.request.contextPath}/processaUsuario">

            <input name="acao" type="hidden" value="excluir"/>
            <input name="id" type="hidden" value="${requestScope.usuario.id}"/>

            <table class="tabelaListagem">
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>${requestScope.usuario.nome}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">CPF:</td>
                    <td>${requestScope.usuario.cpf}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Email:</td>
                    <td>${requestScope.usuario.email}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Telefone Fixo:</td>
                    <td>${requestScope.usuario.telefoneFixo}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Telefone Celular:</td>
                    <td>${requestScope.usuario.telefoneCelular}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Endereço:</td>
                    <td>${requestScope.usuario.endereco}</td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/usuarios/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Excluir"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>