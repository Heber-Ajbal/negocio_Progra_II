/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Heber
 */
public class conexion {
    Connection con;
    
    public conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/negocio", "root", "");
        }catch(Exception e){
            System.err.println("Nel, no sirve tu conexión: "+ e);
        }
    }
    
    
    public Connection gertConnection(){
        return con;
    }
}
