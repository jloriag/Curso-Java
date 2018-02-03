/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.dao;

import cr.ac.una.icai.videojsf.clases.Pelicula;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class PeliculaAD {
    
    private Conexion con;
    private PreparedStatement sentencia;

    public PeliculaAD() {
        this.con = new Conexion();
        this.sentencia = null;
    }
    
    
    public Integer insertar(Pelicula peli){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("insert into video.pelicula values (?,?,?,?,?)");
                this.sentencia.setInt(1, peli.getCodigo());
                this.sentencia.setString(2, peli.getNombre());
                this.sentencia.setString(3, peli.getProductora());
                this.sentencia.setInt(4, peli.getTipo());
                this.sentencia.setInt(5, peli.getTaquillera());
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
    
    public Integer eliminar(Pelicula peli){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("delete from video.pelicula where codigo = ?");
                this.sentencia.setInt(1, peli.getCodigo());
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
    
    public Integer modificar(Pelicula profe){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("update video.pelicula set nombre = ?, productora = ?,"
                            + " tipo = ?, taquillera = ? where codigo = ?");
                this.sentencia.setString(1, profe.getNombre());
                this.sentencia.setString(2, profe.getProductora());
                this.sentencia.setInt(3, profe.getTipo());
                this.sentencia.setInt(4, profe.getTaquillera());
                this.sentencia.setInt(5, profe.getCodigo());
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
    
    public Pelicula consultaXCodigo(Integer codigo){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("select * from video.pelicula where codigo = ?");
                this.sentencia.setInt(1, codigo);
                ResultSet resultado = this.sentencia.executeQuery();
                
                Pelicula peli = new Pelicula();
                while(resultado.next()){
                    peli.setCodigo(resultado.getInt(1));
                    peli.setNombre(resultado.getString("nombre"));
                    peli.setTipo(resultado.getInt(3));
                    peli.setTaquillera(resultado.getInt("taquillera"));
                }
                this.con.desconectarse();
                return peli; // retorna 0 cuando todo esta bien
            }else{
                
                return null; // retorna 1 cuando no se conecta a la BD
            }
            
        }catch (SQLException ex) {
                return null; // retorna 2 cuando cae al catch
            }
    }
    
    public List<Pelicula> consultaXNombre(String nombre){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("select * from video.pelicula where nombre = ?");
                this.sentencia.setString(1, nombre);
                ResultSet resultado = this.sentencia.executeQuery();
                
                List<Pelicula> lista = new ArrayList<>();                
                while(resultado.next()){
                    Pelicula peli = new Pelicula();
                    peli.setCodigo(resultado.getInt(1));
                    peli.setNombre(resultado.getString("nombre"));
                    peli.setTipo(resultado.getInt(3));
                    peli.setTaquillera(resultado.getInt("taquillera"));
                    lista.add(peli);
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
    
    public List<Pelicula> consultaTodos(){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("select * from video.pelicula");
                ResultSet resultado = this.sentencia.executeQuery();
                
                
                List<Pelicula> lista = new ArrayList<>();
                
                while(resultado.next()){
                     Pelicula peli = new Pelicula();
                    peli.setCodigo(resultado.getInt(1));
                    peli.setNombre(resultado.getString("nombre"));
                    peli.setProductora(resultado.getString("productora"));
                    peli.setTipo(resultado.getInt(4));
                    peli.setTaquillera(resultado.getInt("taquillera"));
                    lista.add(peli);
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
