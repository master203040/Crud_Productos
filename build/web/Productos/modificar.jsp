

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Almacen</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h1 class="text-center fw-bold">Modificar Registro</h1>
        <div class="container border shadow-lg p-3 mb-5 bg-body rounded">
            <form action="ProductosController?accion=modificar" method="POST" autocomplete="off" class="">
                <input class="form-control form-control-sm" type="hidden" name="id" id="id">
                <label class=" fw-bold">Codigo:</label>
                <input class="form-control form-control-sm " type="text" id="codigo" name="codigo" id="">
                <label class=" fw-bold">Nombre:</label>
                <input class="form-control form-control-sm" type="text" id="nombre" name="nombre">
                <label class=" fw-bold">Precio:</label>
                <input class="form-control form-control-sm" type="numbre" id="precio" name="precio">
                <label class=" fw-bold">Existencia:</label>
                <input class="form-control form-control-sm" type="numbre" id="existencia" name="existencia">
                <button class="btn btn-primary mt-2" type="submit" name="guardar" id="guardar">
                    Guardar
                </button>
            </form> 
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
