package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAO {

    Connection conexion;

    public ProductosDAO() throws ClassNotFoundException {
        Conexion con = new Conexion();
        conexion = con.getConnection();
    }

    public List<Productos> ListarProductos() {

        PreparedStatement ps;
        ResultSet rs;

        List<Productos> listar = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT id,codigo,nombre,precio,existencia FROM productos");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                int existencia = rs.getInt("existencia");

                Productos producto = new Productos(id, codigo, nombre, precio, existencia);

                listar.add(producto);
            }
            return listar;

        } catch (SQLException e) {

            System.out.println(e.toString());
            return null;
        }
    }

    public Productos mostrarProducto(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        Productos producto = null;

        try {
            ps = conexion.prepareStatement("SELECT id,codigo,nombre,precio,existencia FROM productos WHERE =?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                int existencia = rs.getInt("existencia");

                producto = new Productos(id, codigo, nombre, precio, existencia);

            }
            return producto;

        } catch (SQLException e) {

            System.out.println(e.toString());
            return null;
        }
    }

    public Boolean insertar(Productos producto) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("INSERT INTO productos (codigo,nombre,precio,existencia) VALUES (?,?,?,?)");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getExistencia());
            ps.executeQuery();
            return true;

        } catch (SQLException e) {

            System.out.println(e.toString());
            return null;
        }
    }

    public Boolean actualizar(Productos producto) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("UPDATE productos SET codigo=?,nombre=?,precio=?,existencia=? WHERE id=?");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getExistencia());
            ps.setInt(5, producto.getId());
            ps.executeQuery();
            return true;

        } catch (SQLException e) {

            System.out.println(e.toString());
            return null;
        }
    }

    public Boolean eliminar(int _id) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("DELETE * FROM productos  WHERE id=?");

            ps.setInt(1,_id);
            ps.executeQuery();
            return true;

        } catch (SQLException e) {

            System.out.println(e.toString());
            return null;
        }
    }

}
