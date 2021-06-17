/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author reyna
 */


public class conexion {
    
    private final String base = "bd_planilla";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    Connection con;
    
      
      
   
      
    public Connection getConnection(){
     
          try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              con = DriverManager.getConnection(this.url,this.user,this.password);
             // JOptionPane.showMessageDialog(null, "Conexion exitosa");
          } catch (SQLException e) {
              System.out.println(e);
              
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return con;

      }
     
}



