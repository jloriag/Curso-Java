/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.dao;

import cr.ac.una.icai.videojsf.clases.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Estudiante
 */
public class UsuarioAD {
    
    private Conexion con;
    private PreparedStatement sentencia;

    public UsuarioAD() {
        this.con = new Conexion();
        this.sentencia = null;
    }
    
    public boolean consultaUser(String nombre, String password){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("select * from video.usuario where user = ? and password = ?");
                this.sentencia.setString(1, nombre);
                this.sentencia.setString(2, password);
                ResultSet resultado = this.sentencia.executeQuery();
                
                Usuario us =null;
                while(resultado.next()){
                    us = new Usuario();
                    us.setUser(resultado.getString("user"));
                    us.setPassword(resultado.getString("password"));
                }
                this.con.desconectarse();
                if(us == null){
                    return false;
                }else{
                    return true;
                }
            }else{
                return false; 
            }
        }catch (SQLException ex) {
                return false; 
            }
    }
    
    public Conexion getCon() {
        return con;
    }

    public void setCon(Conexion con) {
        this.con = con;
    }

    public PreparedStatement getSentencia() {
        return sentencia;
    }

    public void setSentencia(PreparedStatement sentencia) {
        this.sentencia = sentencia;
    }
}
