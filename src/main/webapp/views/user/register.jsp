<%--
  Created by IntelliJ IDEA.
  User: abrah
  Date: 7/26/2021
  Time: 7:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Registrar Usuario | Tiendita</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
<h1>Registrar Usuario</h1>
<form action="${context}/ServletUser" method="POST">
    <input type="hidden" value="create" name="action">
    <label>Nombre(s):</label>
    <input class="form-control" type="text" name="name" />
    <br>
    <label>Apellido(s):</label>
    <input class="form-control" type="text" name="lastname" />
    <br>
    <label>Edad:</label>
    <input class="form-control" type="number" name="age" />
    <br>
    <label>Correo:</label>
    <input class="form-control" type="email" name="email" />
    <br>
    <label>Contraseña:</label>
    <input class="form-control" type="password" name="password" />
    <br>
    <label>Rol:</label>
    <select class="form-select" name="role">
        <option value="1">Administrador</option>
        <option value="2">Director</option>
    </select>

    <button type="button" class="btn btn-secondary"><i class="fas fa-times"></i> Cancelar</button>
    <button type="submit" class="btn btn-success"><i class="fas fa-plus"></i> Agregar</button>
</form>

<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>
</html>
