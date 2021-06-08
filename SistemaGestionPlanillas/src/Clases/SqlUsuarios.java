/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class SqlUsuarios extends  conexion {
            public boolean registrar (tb_usuario  usr){
                PreparedStatement ps = null;
                
                Connection con = getConnection();
                String sql = "INSERT INTO usuario (nombre , password, id_rol) VALUES  (?,?,?)";
                
                try {
                    //hacemos la consulta y  enviamos la variable sql

                    ps  = con.prepareStatement(sql);
                    //hacemos una conexion entre el modelo para poder insertarlo en la BD
                    ps.setString(1,usr.getNombre());
                     ps.setString(2,usr.getPassword());
                     ps.setInt(3, usr.getId_rol());
                     
                     //ejecutamos la  inserccion
                     
                     ps.execute();
                     return true;
                } catch (SQLException ex) {
                    Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
                
            }

    
}
