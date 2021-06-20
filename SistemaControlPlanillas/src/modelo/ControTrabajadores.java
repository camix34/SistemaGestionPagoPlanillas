/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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

//Clase para administrar las consultas de la tabla empleados de la base de datos
public ControTrabajadores(){
    url="jdbc:mysql://localhost:3306/bd_planilla";
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
    
    //Funcion que me retorna todos los empleados registrados en la base de datos
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
        
        //Funcion para cerrar la conexion a la base de datos
         public void cerrarConexion(){
    try {
        conexion.close();
    } catch (SQLException ex) {
        Logger.getLogger(ControTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
         
         //Funcion para Insertar un nuevo empleado a la base de datos
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
    
    //Funcion para modifica la informacion personal del empleado
    public boolean editar(empleados p){
        
    try {
        String sqlConsulta ="UPDATE empleados SET nombre='"+p.nombre+"',dui='"+p.dui+"',cargo='"+p.cargo+"',direccion='"+p.direccion+"',telefono='"+p.telefono+"' WHERE id_empleado="+p.id_empleado;
        estate = conexion.createStatement();
        estate.executeUpdate(sqlConsulta);
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(ControTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
    }
    
    //Funcion para eliminar un empleado del sistema
       public boolean Eliminar(int id){
        
    try {
        String sqlConsulta ="DELETE FROM empleados WHERE id_empleado="+id;
        estate = conexion.createStatement();
        estate.executeUpdate(sqlConsulta);
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(ControTrabajadores.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
    }
    
}
