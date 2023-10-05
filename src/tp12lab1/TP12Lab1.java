/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp12lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Bruno
 */
public class TP12Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        try {
            
            Class.forName("org.mariadb.jdbc.Driver");
            String URL="jdbc:mariadb://localhost:3306/tp12";
            String USUARIO="root";
            String PASSWORD="";
            
            Connection con=DriverManager.getConnection(URL,USUARIO,PASSWORD);
            String sqlLine;
            PreparedStatement carga;
            
            
            
            sqlLine = "INSERT INTO `empleado`( `dni`, `apellido`, `nombre`, `acceso`, `estado`)"
            +" VALUES (2134214312,'Issem','Lenoil',1,1)";
            
            carga = con.prepareStatement(sqlLine);
            carga.executeUpdate();
            
            sqlLine = "INSERT INTO `empleado`( `dni`, `apellido`, `nombre`, `acceso`, `estado`)"
            +" VALUES (21342144234,'Mujica','Pepe',1,1)";
            
            carga = con.prepareStatement(sqlLine);
            carga.executeUpdate();
            
            sqlLine = "INSERT INTO `empleado`( `dni`, `apellido`, `nombre`, `acceso`, `estado`)"
            +" VALUES (213424643634,'Fort','Ricardo',1,1)";
            
            carga = con.prepareStatement(sqlLine);
            carga.executeUpdate();

            sqlLine = "INSERT INTO `herramienta`(`nombre`, `descripcion`, `stock`, `estado`) "
                    + "VALUES ('Llave Holandesa','Mueve tuercas',3,1)";
            
              carga = con.prepareStatement(sqlLine);
              carga.executeUpdate();
              
            sqlLine = "INSERT INTO `herramienta`(`nombre`, `descripcion`, `stock`, `estado`) "
                    + "VALUES ('Llave Rusa','Mueve tuercas',30,1)";
              carga = con.prepareStatement(sqlLine);
              carga.executeUpdate();
              sqlLine = "SELECT * FROM herramienta WHERE stock >= 10; ";
              carga = con.prepareStatement(sqlLine);
              ResultSet query = carga.executeQuery();
              
               while (query.next()) {
                      System.out.println("Herramienta: "+ query.getString("nombre"));
                      System.out.println("Descripcion: "+ query.getString("descripcion"));
                      System.out.println("Stock: "+ query.getInt("stock"));
                      System.out.println("Estado: "+ query.getBoolean("estado"));
                      System.out.println("---------------------");
            }

                sqlLine = "UPDATE `empleado` SET `estado`=0 WHERE id_empleado=6";
                carga = con.prepareStatement(sqlLine);
                carga.executeUpdate();
                   
    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TP12Lab1.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
