/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.dao;

import cr.ac.una.icai.videojsf.clases.Actor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
        public Integer modificar(Actor actor){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("UPDATE actor SET nombre=?, nacionalidad=? WHERE codigoActor=?;");
                this.sentencia.setString(1, actor.getNombre());
                this.sentencia.setString(2, actor.getNacionalidad());
                this.sentencia.setInt(3, actor.getCodigoActor());
                int i = this.sentencia.executeUpdate();
                this.con.desconectarse();
                if(i == 0){
                    return 3;
                }
                return 0; // retorna 0 cuando todo esta bien
            }else{
                return 1; // retorna 1 cuando no se conecta a la BD
            }
            
        }catch (SQLException ex) {
                return 2; // retorna 2 cuando cae al catch
            }
    }
    
    public Integer eliminar(Actor actor){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("DELETE FROM actor WHERE codigoActor=?;");
                this.sentencia.setInt(1, actor.getCodigoActor());
                int i = this.sentencia.executeUpdate();
                this.con.desconectarse();
                if(i == 0){
                    return 3;
                }else{
                    return 0; // retorna 0 cuando todo esta bien
                }
            }else{
                return 1; // retorna 1 cuando no se conecta a la BD
            }
            
        }catch (SQLException ex) {
                return 2; // retorna 2 cuando cae al catch
            }
    }
    
    public Actor consultaXCodigo(Integer codigo){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("SELECT codigoActor, nombre, nacionalidad FROM actor WHERE codigoActor=?;");
                this.sentencia.setInt(1, codigo);
                ResultSet resultado = this.sentencia.executeQuery();
                
                Actor actor = new Actor();
                while(resultado.next()){
                    actor.setCodigoActor(resultado.getInt(1));
                    actor.setNombre(resultado.getString("nombre"));
                    actor.setNacionalidad(resultado.getString(3));
                }
                this.con.desconectarse();
                return actor; // retorna 0 cuando todo esta bien
            }else{
                
                return null; // retorna 1 cuando no se conecta a la BD
            }
            
        }catch (SQLException ex) {
                return null; // retorna 2 cuando cae al catch
            }
    }
    
    public List<Actor> consultaXNombre(String nombre){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("SELECT codigoActor, nombre, nacionalidad FROM actor WHERE nombre=?;");
                this.sentencia.setString(1, nombre);
                ResultSet resultado = this.sentencia.executeQuery();
                
                List<Actor> lista = new ArrayList<>();  
                Actor actor;
                while(resultado.next()){
                    actor=new Actor();
                    actor.setCodigoActor(resultado.getInt(1));
                    actor.setNombre(resultado.getString("nombre"));
                    actor.setNacionalidad(resultado.getString(3));
                    lista.add(actor);
                }
                this.con.desconectarse();
                return lista; // retorna 0 cuando todo esta bien
            }else{
                return null; // retorna 1 cuando no se conecta a la BD
            }
            
        }catch (SQLException ex) {
                return null; // retorna 2 cuando cae al catch
            }
    }
    
    public List<Actor> consultaTodos(){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("SELECT codigoActor, nombre, nacionalidad FROM actor ");
                ResultSet resultado = this.sentencia.executeQuery();
                
                
                List<Actor> lista = new ArrayList<>();
                Actor actor;
                while(resultado.next()){
                    actor=new Actor();
                    actor.setCodigoActor(resultado.getInt(1));
                    actor.setNombre(resultado.getString("nombre"));
                    actor.setNacionalidad(resultado.getString(3));
                    lista.add(actor);
                }
                this.con.desconectarse();
                return lista; // retorna 0 cuando todo esta bien
            }else{
                return null; // retorna 1 cuando no se conecta a la BD
            }
            
        }catch (SQLException ex) {
                return null; // retorna 2 cuando cae al catch
            }
    }
    
    
}
