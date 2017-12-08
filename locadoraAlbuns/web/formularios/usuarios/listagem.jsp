<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários Cadastrados</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>
        
        <h1>Usuários Cadastrados</h1>

        <p><a href="${pageContext.request.contextPath}/formularios/usuarios/novo.jsp">Novo Usuário</a></p>

        <table class="tabelaListagem">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Email</th>
                    <th>Telefone Fixo</th>
                    <th>Telefone Celular</th>
                    <th>Endereço</th>
                </tr>
            </thead>
            <tbody>

                <jsp:useBean id="servicos" scope="page" class="locadoraAlbuns.servicos.UsuarioServices"/>

                <c:forEach items="${servicos.todos}" var="usuario">
                    <tr>
                        <td>${usuario.id}</td>
                        <td>${usuario.nome}</td>
                        <td>${usuario.cpf}</td>
                        <td>${usuario.email}</td>
                        <td>${usuario.telefoneFixo}</td>
                        <td>${usuario.telefoneCelular}</td>
                        <td>${usuario.endereco}</td>
                        <td><a href="${pageContext.request.contextPath}/processaUsuario?acao=prepAlteracao&id=${usuario.id}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/processaUsuario?acao=prepExclusao&id=${usuario.id}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/formularios/usuarios/novo.jsp">Novo Usuário</a></p>
        
        <p><a href="${pageContext.request.contextPath}/index.jsp">Tela Principal</a></p>

    </body>

</html>