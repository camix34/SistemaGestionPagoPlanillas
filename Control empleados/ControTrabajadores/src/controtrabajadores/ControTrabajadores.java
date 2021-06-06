/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controtrabajadores;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**

 * @author toshiba

 */


public class ControTrabajadores {
    public Connection conexion;
private String url,user,pass;
private Statement estate;
private ResultSet respuesta;

public ControTrabajadores(){
    url="jdbc:mysql://localhost:3306/bd_planillas";
    user = "root";
    pass= "";
    
    
    try {
        conexion = DriverManager.getConnection(url,user,pass);
        System.out.println("conexion establecida");
    } catch (SQLException ex) {
        Logger.getLogger(ControTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ControTrabajadores p = new ControTrabajadores();
    }
    
        public ResultSet Cargar(){
    try {
        estate = conexion.createStatement();
        respuesta = estate.executeQuery("SELECT * FROM empleados");
        return respuesta;
    } catch (SQLException ex) {
        Logger.getLogger(ControTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    }
  
        
    }
        
         public void cerrarConexion(){
    try {
        conexion.close();
    } catch (SQLException ex) {
        Logger.getLogger(ControTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
         
             public boolean insertar(empleados p){
        
    try {
        String sqlConsulta ="INSERT INTO empleados(id_empleado,nombre,dui,cargo,direccion,telefono,fecha_contratacion) VALUES(null,'"+p.nombre+"','"+p.dui+"','"+p.cargo+"','"+p.direccion+"','"+p.telefono+"','"+p.fecha_contratacion+"')";
        estate = conexion.createStatement();
        estate.executeUpdate(sqlConsulta);
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(ControTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
    }
    
}
