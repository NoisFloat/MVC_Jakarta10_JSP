<%--
  Created by IntelliJ IDEA.
  User: onoel
  Date: 13/7/2024
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nueva Editorial</title>
    <%@ include file='/cabecera.jsp' %>
</head>
<body>
<form role="form" action="${contextPath}/generos" method="POST">
    <input type="hidden" name="operacion" value="insertar"/>
    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Campos requeridos</strong></div>
    <div class="form-group">
        <label for="codigo">Código de la Editorial</label>
        <div class="input-group">
            <input type="text" class="form-control" name="idGenero"
                   id="codigo" value="${genero.idGenero}" readonly placeholder="El código es generado por el sistema" >
            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
        </div>
    </div>
    <div class="form-group">
        <label for="nombre">Nombre de la Editorial</label>
        <div class="input-group">
            <input type="text" class="form-control" name="nombreGenero"
                   id="nombre" value="${genero.nombreGenero}" placeholder="Ingresa el nombre de la editorial" >
            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
        </div>
    </div>
    <div class="form-group">
        <label for="nacionalidad">Nacionalidad de la Editorial</label>
        <div class="input-group">
            <input type="text" class="form-control" id="nacionalidad"
                   value="${genero.descripcion}" name="descripcion" placeholder="Ingresa la nacionalidad de la editorial">
            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
        </div>
    </div>
    ${errores}
    <input type="submit" class="btn btn-info" value="Guardar" name="Guardar">
    <a class="btn btn-danger" href="${contextPath}/generos?operacion=listar">Cancelar</a>
</form>
</body>
</html>
