

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Almacen</title>
    </head>
    <body>
        <h1>Modificar Registro</h1>
        <br/>
        <form action="" method="POST" autocomplete="off">
            <input type="hidden" name="id" id="id">
            <label>Codigo:</label>
            <input type="text" id="codigo" name="codigo">
            <label>Nombre:</label>
            <input type="text" id="nombre" name="nombre">
            <label>Precio:</label>
            <input type="numbre" id="precio" name="precio">
            <label>Existencia:</label>
            <input type="numbre" id="existencia" name="existencia">
            <button type="submit" name="guardar" id="guardar">
                Guardar
            </button>
        </form>
    </body>
</html>
