
package cr.ac.una.icai.videojsf.dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private Connection con;

    public Conexion() {
        this.con = null;
    }
    
    public boolean conectarse(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost:3306/video";
            String usuario = "root";
            String password = "";
            this.con = (Connection) 
                    DriverManager.getConnection(servidor, usuario, password);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }
    
    public boolean desconectarse(){
        try {
            this.con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    
    
    
    
}
