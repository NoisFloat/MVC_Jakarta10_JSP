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
    <title>Modificar Editorial</title>
    <%@ include file='/cabecera.jsp' %>
</head>
<body>
<form role="form" action="${contextPath}/editoriales" method="POST">
    <input type="hidden" name="operacion" value="modificar"/>
    <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Campos requeridos</strong></div>
    <div class="form-group">

        <label for="codigo">Codigo de la Editorial</label>
        <div class="input-group">
            <input type="text" class="form-control" name="codigoEditorial"
                   id="codigo" value="${editorial.codigoEditorial}" readonly placeholder="Ingresa el codigo de la editorial" >
            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
        </div>
    </div>
    <div class="form-group">
        <label for="nombre">Nombre</label>
        <div class="input-group">
            <input type="text" class="form-control" name="nombreEditorial"
                   id="nombre" value="${editorial.nombreEditorial}" placeholder="Ingresa el nombre de la editorial" >
            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
        </div>
    </div>
    <div class="form-group">
        <label for="contacto">Nombre de contacto</label>
        <div class="input-group">
            <input type="text" class="form-control" id="contacto"
                   value="${editorial.contacto}" name="contacto" placeholder="Ingresa el contacto de la editorial">
            <span class="input-group-addon"><span class="glyphiconglyphicon-asterisk"></span></span>
        </div>
    </div>
    <div class="form-group">
        <label for="contacto">Telefono</label>
        <div class="input-group">
            <input type="text" class="form-control" id="telefono"
                   value="${editorial.telefono}" name="telefono" placeholder="Ingresa el telefono de la editorial">
            <span class="input-group-addon"><span class="glyphiconglyphicon-asterisk"></span></span>
        </div>
    </div>
    ${errores}

    <input type="submit" class="btn btn-info" value="Guardar"
           name="Guardar">
    <a class="btn btn-danger"
       href="${contextPath}/editoriales?operacion=listar">Cancelar</a>
</form>
</body>
</html>
