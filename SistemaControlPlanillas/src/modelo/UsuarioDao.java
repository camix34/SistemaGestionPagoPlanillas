/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author gabri
 */
public class UsuarioDao {
    PreparedStatement ps;
    ResultSet rs;
    
    EntidadUsuario eu = new EntidadUsuario();
    Conexion con = new Conexion();
    Connection acceso;
    
    public EntidadUsuario validarusuario(String password ,String nombre,String id_rol){
        String sql="SELECT * FROM Usuario WHERE password=? and nombre=? and id_rol=?";
        try {
            acceso=con.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, nombre);
            ps.setString(3, id_rol);
            
            
            rs=ps.executeQuery();
            while (rs.next()) {
                eu.setId(rs.getInt(1));
                eu.setNombre(rs.getString(2));
                eu.setPassword(rs.getString(3));
                eu.setId_rol(rs.getString(4));
                
                
            }
        } catch (Exception e) {
        }
        return eu;
    }
    
    
    
    
}
