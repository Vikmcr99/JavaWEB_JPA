<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Consulta</title>
    </head>
    <body>
        <div class="container">
            <h1>Consulta de Alunos</h1>
            <form method="get" action="procurar">
                <input type="texto" name ="keyword">
                <input type="submit" value="Proucurar">
            </form>
            <h3><a href="cadastro">Novo aluno</a></h3>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Telefone</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lista}" var="aluno">
                        <tr>
                            <td>${aluno.nome}</td>
                            <td>${aluno.telefone}</td>
                            <td>
                                <a href="alterar?id=${aluno.id}">Alterar</a>
                                <a href="excluir?id=${aluno.id}">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>