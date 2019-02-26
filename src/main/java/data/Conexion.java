/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import co.com.poli.juegaFutbol.models.Reserva;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sala305
 */
public class Conexion {
    
    private static String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String dbUsuario = "juegafutbol";
    private static String dbContrasena = "123";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("oracle.jdbc.OracleDriver");
        con = DriverManager.getConnection(dbUrl, dbUsuario, dbContrasena);
        return con;
    }
    
    public static void cerrarConexion(Connection con) throws SQLException{
        con.close();
    }

}
