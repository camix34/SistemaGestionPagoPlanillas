/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author reyna
 */
public class ConsultaPago extends Conexion{
    
    //atributos
    public Conexion conn = new Conexion();
      PreparedStatement ps;
      ResultSet rs;
  
      //METODOS

      //Funcion crear o  registrar una planilla
    public boolean registrar(Pago p) {

       
        Connection con = conn.Conectar();

        String sql = "INSERT INTO pagoempleados (id_empleado,nombre,salario_base,isss, afp, fecha_pago,salario_total) VALUES(?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(p.getIdempleado()));
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getSalario_base());
            ps.setDouble(4, p.getIsss());
            ps.setDouble(5, p.getAfp());
            ps.setDate(6, p.getFecha());
            ps.setDouble(7, p.getTotal());

            ps.execute();
            return true;
        } catch (Exception e) {

            System.err.println(e);
            return false;
        } finally {

            try {
                con.close();
            } catch (SQLException e) {

                System.err.println(e);
            }

        }

    }

    //Funcion modificar planilla de pago - este por el momento no fue usada
    public boolean modificar(Pago p) {

       
        Connection con = conn.Conectar();

        String sql = "UPDATE pagoempleados SET id_empleado=?, salario_base=?, isss=?, afp=?, descuento=?, fecha_pago=?, salario_total WHERE id_pago=?";

       try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(p.getIdempleado()));
            ps.setDouble(2, p.getSalario_base());
            ps.setDouble(3, p.getIsss());
            ps.setDouble(4, p.getAfp());
            ps.setDouble(5, p.getDescuento());
            ps.setDate(6, p.getFecha());
            ps.setDouble(7, p.getTotal());
            ps.setInt(7, p.getId());
            ps.execute();
            return true;
        } catch (Exception e) {

            System.err.println(e);
            return false;
        } finally {

            try {
                con.close();
            } catch (SQLException e) {

                System.err.println(e);
            }

        }


    }

    //Funcion para eliminar una planilla de un empleado
    public boolean eliminar(Pago p) {

      
       Connection con = conn.Conectar();

        String sql = "DELETE FROM pagoempleados WHERE id_pago=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {

            System.err.println(e);
            return false;
        } finally {

            try {
                con.close();
            } catch (Exception e) {

                System.err.println(e);
            }

        }

    }
    
    //Funcion que me calcula el salario base de un empleado dadas 2 fechas(un mes)
    public Double salarioBase(Pago p){
    
        Double salariobase = 0.0;
    Connection con = conn.Conectar();
   
         String sql = "SELECT total_dia FROM infopago WHERE id_empleado=? AND fecha BETWEEN ? AND ? ";

        try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, Integer.parseInt(p.getIdempleado()));
           ps.setDate(2, p.getFechainicial());
           ps.setDate(3, p.getFechafinal());
           
            rs = ps.executeQuery();
            
            while(rs.next()){
            
            
            salariobase = salariobase + Double.parseDouble(rs.getString("total_dia")) ;
            
            }
            
            System.out.println(salariobase);
            return salariobase;

        }catch(Exception e){
        
         System.err.println(e);
         
        
        return 0.0;
        }
       
    }
    
    
    
}
