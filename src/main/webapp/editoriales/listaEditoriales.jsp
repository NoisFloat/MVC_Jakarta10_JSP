<%--
  Created by IntelliJ IDEA.
  User: onoel
  Date: 13/7/2024
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista Editoriales</title>
    <%@include file="../cabecera.jsp"%>
</head>
<body>
<%@include file="../menu.jsp"%>

<h1>Detalles de las Editoriales</h1>
<table class="table table-striped table-bordered table-hover" id="tabla">
    <a type="button" class="btn btn-primary btn-md" href="${contextPath}/editoriales/nuevaEditorial.jsp"> Nuevo autor</a>

    <thead>
    <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Contacto</th>
        <th>Teléfono</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${editoriales}" var="editoriales">
        <tr>
            <td>${editoriales.codigoEditorial}</td>
            <td>${editoriales.nombreEditorial}</td>
            <td>${editoriales.contacto}</td>
            <td>${editoriales.telefono}</td>
            <td>
                <a class="btn btn-primary"
                   href="${contextPath}/editoriales?operacion=verDetalles&id=${editoriales.codigoEditorial}"><span class="glyphicon glyphicon-edit"></span> Editar</a>
                <a class="btn btn-danger"
                   href="javascript:eliminar('${editoriales.codigoEditorial}')"><span class="glyphicon glyphicontrash"></span> Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    $(document).ready(function(){
        $('#tabla').DataTable();
    });
    <c:if test="${not empty exito}">
    alertify.success('${exito}');
    <c:set var="exito" value="" scope="session" />
    </c:if>
    <c:if test="${not empty fracaso}">
    alertify.error('${fracaso}');
    <c:set var="fracaso" value="" scope="session" />
    </c:if>
    function eliminar(id){
        alertify.confirm("¿Realmente desea eliminar este Autor?", function(e){
            if(e){
                location.href="editoriales?operacion=eliminar&id="+ id;
            }
        });
    }
</script>
</body>
</html>
