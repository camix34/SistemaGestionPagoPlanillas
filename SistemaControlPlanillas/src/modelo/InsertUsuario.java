/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class InsertUsuario implements CRUD {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        
       List<EntidadUsuario> lista = new ArrayList<>();
       String sql="SELECT * FROM usuario"; 
       try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                EntidadUsuario eu = new EntidadUsuario();
                eu.setId(rs.getInt(1));
                eu.setNombre(rs.getString(2));
                eu.setPassword(rs.getString(3));
                eu.setId_rol(rs.getString(4));
                lista.add(eu);
            }
        } catch (Exception e) {
        }
       return lista;
    }

    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO usuario(nombre,password,id_rol) VALUES(?,?,?)";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            r=ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r=0;
        String sql="UPDATE usuario SET nombre=? , password=? , id_rol=? WHERE id_usuario=?";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            
            r=ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql="DELETE FROM usuario WHERE id_usuario=?";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       ;
    }
    
    
    
}
