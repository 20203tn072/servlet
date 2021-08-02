<%--
  Created by IntelliJ IDEA.
  User: abrah
  Date: 7/30/2021
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Listado de peliculas</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${context}/assets/dist/css/styles.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
<a href="${context}/views/peli/register.jsp" class="btn btn-outline-success"><i class="fas fa-plus"></i> Agregar Pelicula</a>
<table class="table">
    <thead class="table-dark">
    <tr>
        <th>No.</th>
        <th>Nombre de la Pleicula</th>
        <th>Descripción</th>
        <th>Fecha de Estreno</th>
        <th>Recaudación</th>
        <th>Estado</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ listUsers }" var="user" varStatus="status">
        <tr>
            <td>${ status.count }</td>
            <td>${ peli.idPelicula.nombre }</td>
            <td>${ peli.descripcion }</td>
            <td>${ peli.estreno }</td>
            <td>${ peli.recaudacion }</td>
            <td>
                <c:if test="${ peli.status == 1 }">
                    <span class="badge rounded-pill bg-success">Activo</span>
                </c:if>
                <c:if test="${ peli.status == 0 }">
                    <span class="badge rounded-pill bg-danger">Inactivo</span>
                </c:if>
            </td>
            <td>
                <c:if test="${ peli.status == 1 }">
                    <form action="${context}/ServletUser" method="POST" style="display: inline;">
                        <input type="hidden" name="action" value="getUserById">
                        <input type="hidden" name="id" value="${ peli.id }">
                        <button type="submit" class="btn btn-outline-primary"><i class="fas fa-edit"></i> Modificar</button>
                    </form>
                    <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#delete"><i class="fas fa-trash"></i> Eliminar</button>
                </c:if>
                <c:if test="${ peli.status == 0 }">
                    <button type="button" class="btn btn-outline-info"><i class="fas fa-info-circle"></i> Detalles</button>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%-- MODAL --%>
<div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Eliminar pelicula</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                <button type="button" class="btn btn-danger"><i class="fas fa-trash"></i> Eliminar</button>
            </div>
        </div>
    </div>
</div>

<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="${context}/assets/dist/js/main.js"></script>
</body>
</html>
