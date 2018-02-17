/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.dao;

import cr.ac.una.icai.videojsf.clases.Alquiler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class AlquilerAD {
    
    private Conexion con;
    private PreparedStatement sentencia;

    public AlquilerAD() {
        this.con = new Conexion();
        this.sentencia = null;
    }
    
    public Integer insertar(Alquiler alquiler){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("INSERT INTO alquiler(cedula, codigo, fecha, monto, dias) VALUES (?,?,?,?,?);");
                this.sentencia.setInt(1, alquiler.getCedula());
                this.sentencia.setInt(2, alquiler.getCodigo());
                this.sentencia.setTimestamp(4,new Timestamp(alquiler.getFecha().getTime()));
                this.sentencia.setFloat(4, alquiler.getMonto());
                this.sentencia.setInt(5, alquiler.getDias());
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
    
    public Integer modificar(Alquiler alquiler){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("UPDATE alquiler SET nombre=?, telefono=?, direccion=?, montoPagado=? WHERE cedula=?;");
             
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
    
    public Integer eliminar(Alquiler alquiler){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("delete from alquiler where cedula = ?;");
                this.sentencia.setInt(1, alquiler.getCedula());
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
    
    public Alquiler consultaXCedula(Integer cedula){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("SELECT cedula, nombre, telefono, direccion, montoPagado FROM alquiler WHERE cedula=?;");
                this.sentencia.setInt(1, cedula);
                ResultSet resultado = this.sentencia.executeQuery();
                
                Alquiler alquiler = new Alquiler();
                while(resultado.next()){
                    
                }
                this.con.desconectarse();
                return alquiler; // retorna 0 cuando todo esta bien
            }else{
                
                return null; // retorna 1 cuando no se conecta a la BD
            }
            
        }catch (SQLException ex) {
                return null; // retorna 2 cuando cae al catch
            }
    }
    
    public List<Alquiler> consultaXNombre(String nombre){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("SELECT cedula, nombre, telefono, direccion, montoPagado FROM alquiler WHERE nombre=?;");
                this.sentencia.setString(1, nombre);
                ResultSet resultado = this.sentencia.executeQuery();
                
                List<Alquiler> lista = new ArrayList<>();  
                Alquiler alquiler;
                while(resultado.next()){
                 
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
    
    public List<Alquiler> consultaTodos(){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("SELECT cedula, codigo, fecha, monto, dias FROM alquiler");
                ResultSet resultado = this.sentencia.executeQuery();
                
                
                List<Alquiler> lista = new ArrayList<>();
                Alquiler alquiler;
                while(resultado.next()){
                    alquiler=new Alquiler();
                 //   alquiler.setCedula(resultado.get);
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
