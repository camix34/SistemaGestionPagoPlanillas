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

//CLASE PARA LAS CONSULTAS DE LA TABLA  INFO DE PAGO
public class ConsultaInfoPago extends Conexion {

  
     public Conexion conn = new Conexion();
      PreparedStatement ps;
      ResultSet rs;
  
//FUNCION PARA REGISTRAR UN REGISTRO
    public boolean registrar(InfoPago p) {

       
        Connection con = conn.Conectar();

        String sql = "INSERT INTO infopago (id_empleado,fecha,unidades, descuento, total_dia) VALUES(?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(p.getId_Empleado()));
            ps.setDate(2, p.getFecha());
            ps.setInt(3, p.getUnidades());
            ps.setDouble(4, p.getDescuento());
            ps.setDouble(5, p.getTotal_dia());
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
    
    //FUNCION PARA MODIFICAR UN REGISTRO DE LA TABLA INFO PAGO

    public boolean modificar(InfoPago p) {

       
       Connection con = conn.Conectar();

        String sql = "UPDATE infopago SET id_empleado=?, fecha=?, unidades=?, descuento=?, total_dia=? WHERE id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getId_Empleado());
            ps.setDate(2, p.getFecha());
            ps.setInt(3, p.getUnidades());
            ps.setDouble(4, p.getDescuento());
            ps.setDouble(5, p.getTotal_dia());
            ps.setInt(6, p.getId());
            ps.execute();
            return true;
        } catch (Exception e) {

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
    
    //FUNCION PARA ELIMINAR UN REGISTRO DE LA TABLA INFO PAGO 

    public boolean eliminar(InfoPago p) {

      
        Connection con = conn.Conectar();

        String sql = "DELETE FROM infopago WHERE id=?";

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
    
    //FUNCION PARA BUSCAR UN REGISTRO DE LA TABLA INFO PAGO

    public boolean buscar(InfoPago p) {

     
        
        Connection con = conn.Conectar();

        String sql = "SELECT * FROM infopago WHERE id_empleado=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getId_Empleado());
            rs = ps.executeQuery();

            if (rs.next()) {

                p.setId(Integer.parseInt(rs.getString("id")));
                p.setId_Empleado(rs.getString("id_empleado"));
                p.setFecha(Date.valueOf(rs.getString("fecha")));
                p.setUnidades(Integer.parseInt(rs.getString("unidades")));
                p.setDescuento(Double.parseDouble(rs.getString("descuento")));
                p.setTotal_dia(Double.parseDouble(rs.getString("total_dia")));

                return true;
            }

            return false;
        } catch (Exception e) {

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

  

}
