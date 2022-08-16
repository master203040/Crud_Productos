//conexion a la base de datos de mysqlwokbench
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection getConnection() throws ClassNotFoundException {
        //cadela de conexion con un try-catch
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen", "root", "admin1234");
            return conexion;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }

}
