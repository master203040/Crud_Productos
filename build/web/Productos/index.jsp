

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Almacen</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        <h1 class="text-dark text-center fw-bold">Productos</h1>
        <a class="text-dark btn btn-secondary p-2 mx-5 mt-6" href="ProductosController?accion=nuevo">Nuevo Registro</a>
        <div class="container border shadow-lg p-3 mb-5 bg-body rounded mt-3">

            <table class="table">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Existencia</th>
                        <th>Accion</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="producto" items="${lista}">

                        <tr>
                            <td><c:out value="${producto.codigo}"/></td>
                            <td><c:out value="${producto.nombre}"/></td>
                            <td><c:out value="${producto.precio}"/></td>
                            <td><c:out value="${producto.existencia}"/></td>
                            <td><a class=" link-primary  text-decoration-none" href="ProductosController?accion=modificar&id=<c:out value="${producto.id}"/>">Modificar</a></td>
                            <td><a class=" link-danger text-decoration-none" href="ProductosController?accion=eliminar&id=<c:out value="${producto.id}"/>">Eliminar</a></td>

                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
