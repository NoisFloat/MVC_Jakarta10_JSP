<%--
  Created by IntelliJ IDEA.
  User: onoel
  Date: 10/7/2024
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de autores</title>
    <%@ include file='/cabecera.jsp' %>
</head>
<body>
<jsp:include page="/menu.jsp"/>
<div class="container">
    <div class="row">
        <h3>Lista de autores</h3>
    </div>
    <div class="row">
        <div class="col-md-10">
            <a type="button" class="btn btn-primary btn-md" href="${contextPath}/autores.do?op=nuevo"> Nuevo autor</a>
            <br/><br/>
            <table class="table table-striped table-bordered table-hover" id="tabla">
                <thead>
                <tr>
                    <th>Codigo del autor</th>
                    <th>Nombre del autor</th>
                    <th>Nacionalidad</th>

                    <th>Operaciones</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${requestScope.listaAutores}" var="autores">
                    <tr>
                        <td>${autores.codigoAutor}</td>
                        <td>${autores.nombreAutor}</td>
                        <td>${autores.nacionalidad}</td>
                        <td>
                            <a class="btn btn-primary"
                               href="${contextPath}/editoriales?operacion=verDetalles&id=${autores.codigoAutor}"><span
                                    class="glyphicon glyphicon-edit"></span> Editar</a>
                            <a class="btn btn-danger"
                               href="javascript:eliminar('${autores.codigoAutor}')"><span class="glyphicon glyphicontrash"></span> Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>
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
        alertify.confirm("¿Realmente decea eliminar este Autor?", function(e){
            if(e){
                location.href="editoriales?op=eliminar&id="+ id;
            }
        });
    }
</script>
</body>
</html>
