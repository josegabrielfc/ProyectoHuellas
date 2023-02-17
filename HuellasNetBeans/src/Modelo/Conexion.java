/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.JFrame_Sensor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Statement;
/**
 *
 * @author jgfch
 */
public class Conexion {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFrame_Sensor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/tomadeasistencia", "localhost", "");
            //Statement stmt = con.createStatement();
            //stmt.executeUpdate("INSERT INTO estudiante VALUES(1,'1152090','Jennifer','Salazar')");
        } catch (SQLException ex) {
            Logger.getLogger(JFrame_Sensor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se puede conectar a la base de datos");
           
        }
        return con;
    }
}
