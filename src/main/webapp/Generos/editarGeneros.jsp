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
    <title>Modificar Genero</title>
    <%@ include file='/cabecera.jsp' %>
</head>
<body>
<form role="form" action="${contextPath}/generos" method="post">
    <input type="hidden" name="operacion" value="modificar"/>
    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Campos requeridos</strong></div>
    <div class="form-group">
        <label for="idGenero">Código del Género</label>
        <div class="input-group">
            <input type="number" class="form-control" name="idGenero"
                   id="idGenero" value="${genero.idGenero}" readonly placeholder="Ingresa el código del género">
            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
        </div>
    </div>
    <div class="form-group">
        <label for="nombre">Nombre</label>
        <div class="input-group">
            <input type="text" class="form-control" name="nombreGenero" id="nombre" value="${genero.nombreGenero}" placeholder="Ingresa el nombre del genero" >
            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
        </div>
    </div>
    <div class="form-group">
        <label for="descripcion">Nombre de contacto</label>
        <div class="input-group">
            <input type="text" class="form-control" id="descripcion"
                   value="${genero.descripcion}" name="descripcion" placeholder="Ingresa la descripcion del genero">
            <span class="input-group-addon"><span class="glyphiconglyphicon-asterisk"></span></span>
        </div>
    </div>

    ${errores}

    <input type="submit" class="btn btn-info" value="Guardar" name="Guardar">
    <a class="btn btn-danger" href="${contextPath}/generos?operacion=listar">Cancelar</a>
</form>
</body>
</html>
