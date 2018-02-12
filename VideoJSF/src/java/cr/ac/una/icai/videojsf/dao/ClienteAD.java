/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.dao;

import cr.ac.una.icai.videojsf.clases.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class ClienteAD {
    
    private Conexion con;
    private PreparedStatement sentencia;

    public ClienteAD() {
        this.con = new Conexion();
        this.sentencia = null;
    }
    
    public Integer insertar(Cliente cliente){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("INSERT INTO cliente (cedula, nombre, telefono, direccion, montoPagado) VALUES(?, ?, ?, ?, ?);");
                this.sentencia.setInt(1, cliente.getCedula());
                this.sentencia.setString(2, cliente.getNombre());
                this.sentencia.setInt(3, cliente.getTelefono());
                this.sentencia.setString(4, cliente.getDireccion());
                this.sentencia.setFloat(5, cliente.getMontoPagado());
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
    
    public Integer modificar(Cliente cliente){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("UPDATE cliente SET nombre=?, telefono=?, direccion=?, montoPagado=? WHERE cedula=?;");
                this.sentencia.setString(1, cliente.getNombre());
                this.sentencia.setInt(2, cliente.getTelefono());
                this.sentencia.setString(3, cliente.getDireccion());
                this.sentencia.setFloat(4, cliente.getMontoPagado());
                this.sentencia.setInt(5, cliente.getCedula());
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
    
    public Integer eliminar(Cliente cliente){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("delete from cliente where cedula = ?;");
                this.sentencia.setInt(1, cliente.getCedula());
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
    
    public Cliente consultaXCedula(Integer cedula){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("SELECT cedula, nombre, telefono, direccion, montoPagado FROM cliente WHERE cedula=?;");
                this.sentencia.setInt(1, cedula);
                ResultSet resultado = this.sentencia.executeQuery();
                
                Cliente cliente = new Cliente();
                while(resultado.next()){
                    cliente.setCedula(resultado.getInt(1));
                    cliente.setNombre(resultado.getString("nombre"));
                    cliente.setTelefono(resultado.getInt(3));
                    cliente.setDireccion(resultado.getString(4));
                    cliente.setMontoPagado(resultado.getFloat("montoPagado"));
                }
                this.con.desconectarse();
                return cliente; // retorna 0 cuando todo esta bien
            }else{
                
                return null; // retorna 1 cuando no se conecta a la BD
            }
            
        }catch (SQLException ex) {
                return null; // retorna 2 cuando cae al catch
            }
    }
    
    public List<Cliente> consultaXNombre(String nombre){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("SELECT cedula, nombre, telefono, direccion, montoPagado FROM cliente WHERE nombre=?;");
                this.sentencia.setString(1, nombre);
                ResultSet resultado = this.sentencia.executeQuery();
                
                List<Cliente> lista = new ArrayList<>();  
                Cliente cliente;
                while(resultado.next()){
                    cliente=new Cliente();
                    cliente.setCedula(resultado.getInt(1));
                    cliente.setNombre(resultado.getString("nombre"));
                    cliente.setTelefono(resultado.getInt(3));
                    cliente.setDireccion(resultado.getString(4));
                    cliente.setMontoPagado(resultado.getFloat("montoPagado"));
                    lista.add(cliente);
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
    
    public List<Cliente> consultaTodos(){
        try{
            if(this.con.conectarse()){
                this.sentencia = this.con.getCon().prepareStatement
                    ("SELECT cedula, nombre, telefono, direccion, montoPagado FROM cliente");
                ResultSet resultado = this.sentencia.executeQuery();
                
                
                List<Cliente> lista = new ArrayList<>();
                Cliente cliente;
                while(resultado.next()){
                    cliente=new Cliente();
                    cliente.setCedula(resultado.getInt(1));
                    cliente.setNombre(resultado.getString("nombre"));
                    cliente.setTelefono(resultado.getInt(3));
                    cliente.setDireccion(resultado.getString(4));
                    cliente.setMontoPagado(resultado.getFloat("montoPagado"));
                    lista.add(cliente);
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
