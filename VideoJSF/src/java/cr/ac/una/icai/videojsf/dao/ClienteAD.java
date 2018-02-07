/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.dao;

import cr.ac.una.icai.videojsf.clases.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
    
}
