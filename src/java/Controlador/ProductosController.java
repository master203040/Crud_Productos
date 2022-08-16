package Controlador;

import Modelo.Productos;
import Modelo.ProductosDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.runtime.Debug.id;

@WebServlet(name = "ProductosController", urlPatterns = {"/ProductosController"})
public class ProductosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductosDAO productosDAO = null;
        try {
            productosDAO = new ProductosDAO();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String accion;
        RequestDispatcher dispatcher = null;
        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {

            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Productos> listaProductos = productosDAO.ListarProductos();
            request.setAttribute("lista", listaProductos);
        } else if (accion == "nuevo") {
            dispatcher = request.getRequestDispatcher("Productos/nuevo.jsp");
        } else if (accion == "insertar") {

            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int existencia = Integer.parseInt(request.getParameter("existencia"));

            Productos productos = new Productos(0, codigo, nombre, precio, existencia);

            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            productosDAO.insertar(productos);
            List<Productos> listaProductos = productosDAO.ListarProductos();
            request.setAttribute("lista", listaProductos);

        } else if (accion == "modificar") {
            dispatcher = request.getRequestDispatcher("Productos/modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Productos producto = productosDAO.mostrarProducto(id);
            request.setAttribute("producto", producto);
        } else if (accion == "actualizar") {

            int id = Integer.parseInt(request.getParameter("id"));
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int existencia = Integer.parseInt(request.getParameter("existencia"));

            Productos productos = new Productos(id, codigo, nombre, precio, existencia);

            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            productosDAO.actualizar(productos);
            List<Productos> listaProductos = productosDAO.ListarProductos();
            request.setAttribute("lista", listaProductos);

        } else if (accion == "eliminar") {

            int id = Integer.parseInt(request.getParameter("id"));

            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            productosDAO.eliminar(id);
            List<Productos> listaProductos = productosDAO.ListarProductos();
            request.setAttribute("lista", listaProductos);

        } else {
            //reguesar a la vista inicial 
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Productos> listaProductos = productosDAO.ListarProductos();
            request.setAttribute("lista", listaProductos);

        }
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
