/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.dao;

import cr.ac.una.icai.videojsf.clases.Actor;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author josue
 */
public class ActorAD {
    
    private Conexion con;
    private PreparedStatement sentencia;

    public ActorAD() {
        this.con = new Conexion();
        this.sentencia = null;
    }
    
    public Integer insertar(Actor actor){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("INSERT INTO actor(codigoActor, nombre, nacionalidad)VALUES(?, ?, ?);");
                this.sentencia.setInt(1, actor.getCodigoActor());
                this.sentencia.setString(2, actor.getNombre());
                this.sentencia.setString(3, actor.getNacionalidad());
                this.sentencia.executeUpdate();
                this.con.desconectarse();
                return 0; // retorna 0 cuando todo esta bien
            }else{
                return 1; // retorna 1 cuando no se conecta a la BD
            }
            
        }catch (SQLException ex) {
            if (ex.getSQLState().startsWith("23")){
                return 3;
            }else{
                return 2; // retorna 2 cuando cae al catch
            }
        }
    }
    
    
}
