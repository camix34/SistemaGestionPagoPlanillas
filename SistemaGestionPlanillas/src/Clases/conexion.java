/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author reyna
 */


public class conexion {

    private static Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private final String base = "bdprogramacion";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;
    private Statement estate;
    
      
      
   
      
    public Connection getConnection(){
     
          try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              con = DriverManager.getConnection(this.url,this.user,this.password);
              JOptionPane.showMessageDialog(null, "Conexion exitosa");
          } catch (SQLException e) {
              System.out.println(e);
              
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return con;

      }
    
     public boolean insertar(tb_usuario p){
        
    try {
        String sqlConsulta ="INSERT INTO usuario(id_usuario,nombre,password,id_rol) VALUES('null','"+p.nombre+"','"+p.password+"','null')";
        estate = conexion.createStatement();
        estate.executeUpdate(sqlConsulta);
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
    }
     
}



